package array;

import java.util.PriorityQueue;

public class L378_KthSmallestMatrix {
    /**
     * use a min heap of [cell value, row, col]
     * initialize heap with first column elements
     * pop smallest element and insert the next on the same row only if there are elements left
     * we do this operation k times
     * time complexity: O(nlogn + klogn) => worst case k = n^ 2 then O(n^2 logn)
     * space complexity: O(n)
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int n = matrix.length;
        //initialize minHeap
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        // go through matrix , pop smallest element till k
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            k--;
            if (k == 0) return cur[0];
            int row = cur[1], col = cur[2];
            // after pop , we push next element
            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        return -1;
    }

    /**
     * Solution 2: binary search
     * O(n log (max - min))
     * Where max and min are the maximum and minimum values in the matrix.
     * Space O(1)
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countLessEqual(matrix, mid, n);

            if (count < k) {
                left = mid + 1;
            } else {
                ans = mid; // mid might be the answer
                right = mid - 1;
            }
        }

        return ans;
    }

    /*
    This scans the matrix from the bottom-left to the top-right.
    In each row or column, you move either up or right, at most n times
    Therefore, this runs in O(n) time per binary search iteration.
     */
    private int countLessEqual(int[][] matrix, int target, int n) {
        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += (row + 1); // All elements above are <= target
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}
