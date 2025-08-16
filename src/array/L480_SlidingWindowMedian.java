package array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class L480_SlidingWindowMedian {
    /**
     *  Two heaps approach for finding median:
     *  maxHeap stores smaller half of numbers (max at top)
     *  minHeap stores larger half of numbers (min at top)
     *  Algorithm Steps:
     * 1. Add new element to appropriate heap
     * 2. Balance heaps to maintain size properties
     * 3. Remove element sliding out of window
     * 4. Calculate median when window is complete
     *  Time Complexity: O(n * k) due to remove() operations on heaps
     */
    private PriorityQueue<Long> minHeap = new PriorityQueue<>();
    private PriorityQueue<Long> maxHeap = new PriorityQueue<>((a,b) -> Long.compare(b, a));

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1]; // Result array size

        for (int i = 0; i < n; i++) {
            long num = nums[i]; // Use long to avoid integer overflow

            // Step 1: Add current number to appropriate heap
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num); // Add to smaller half
            } else {
                minHeap.offer(num); // Add to larger half
            }

            // Step 2: Balance heaps to maintain size property
            balanceHeaps();

            // Step 3: Remove element that's sliding out of window
            if (i >= k) { // Window is full and we need to remove oldest element
                long toRemove = nums[i - k]; // Element to remove from window
                if (toRemove <= maxHeap.peek()) {
                    maxHeap.remove(toRemove); // Remove from smaller half
                } else {
                    minHeap.remove(toRemove); // Remove from larger half
                }
                balanceHeaps(); // Rebalance after removal
            }

            // Step 4: Calculate median when window is complete
            if (i >= k - 1) { // Window has k elements
                if (k % 2 == 0) {
                    // Even window size: median is average of two middle elements
                    result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
                } else {
                    // Odd window size: median is the top of maxHeap (middle element)
                    result[i - k + 1] = (double) maxHeap.peek();
                }
            }
        }
        return result;
    }

    /**
     * Maintains heap balance properties:
     * - maxHeap size can be at most 1 larger than minHeap (for odd k)
     * - minHeap size should never exceed maxHeap size
     */
    private void balanceHeaps() {
        // If maxHeap has too many elements, move one to minHeap
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }

        // If minHeap has more elements than maxHeap, move one to maxHeap
        while (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    /**
     * TreeSet solution
     */
    public double[] medianSlidingWindow2(int[] nums, int k) {
        // Custom comparator: compare by value in nums; tie-break using index
        Comparator<Integer> comparator = new Comparator<>() {
            public int compare(Integer a, Integer b) {
                if (nums[a] != nums[b]) {
                    return Integer.compare(nums[a], nums[b]); // compare values
                } else {
                    return a - b; // if same value, compare indices to avoid duplicates
                }
            }
        };

        // TreeSet for left (max-heap side), reversed comparator
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        // TreeSet for right (min-heap side)
        TreeSet<Integer> right = new TreeSet<>(comparator);

        double[] res = new double[nums.length - k + 1];

        // Initialize the first window with the first k elements
        for (int i = 0; i < k; i++) {
            left.add(i);  // insert indices
        }

        // Balance left and right
        balance(left, right);
        res[0] = getMedian(k, nums, left, right);

        // Slide the window
        int r = 1;
        for (int i = k; i < nums.length; i++) {
            // Remove index i-k (outgoing element) from one of the sets
            if (!left.remove(i - k)) {
                right.remove(i - k);
            }

            // Insert new index i into right
            right.add(i);
            // Always move the smallest of right into left to rebalance
            left.add(right.pollFirst());

            // Rebalance sizes
            balance(left, right);

            // Compute median
            res[r] = getMedian(k, nums, left, right);
            r++;
        }

        return res;
    }

    // Ensure left.size() <= right.size() and balance correctly
    private void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
        while (left.size() > right.size()) {
            right.add(left.pollFirst());
        }
    }

    // Get median based on size of k
    private double getMedian(int k, int[] nums, TreeSet<Integer> left, TreeSet<Integer> right) {
        if (k % 2 == 0) {
            return ((double) nums[left.first()] + nums[right.first()]) / 2;
        } else {
            return (double) nums[right.first()];
        }
    }
}
