package array;

public class L1539_KthMissingPositiveNumber {
    /**
     * Binary Search Solution
     * k  = 5
     *                    r   l
     * Index:    0  1  2  3   4
     * Value:    2  3  4  7  11
     * Expected: 1  2  3  4   5
     * Missing:  1  1  1  3   6
     * MissingN: 1  5  6  8   9  10  12

     * Key insight: at any index i, the number of missing positive
     *         integers before arr[i] is arr[i] - (i + 1).
     *         e.g. arr[1] = 3, it should be i + 1, which is 2 here, so 3-2= 1 is missing
     */
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int missingCount = arr[mid] - mid - 1;
            if (missingCount < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // At this point, right is the rightmost index where missing < k
        // The answer is: (right + 1) + k - (missing numbers up to arr[right])
        if (right == -1) {
            // All missing numbers are before the array starts
            return k;
        }

        int missingUpToRight = arr[right] - right - 1;
        return arr[right] + (k - missingUpToRight);
    }

    /**
     * Linear solution
     * cur: Current positive integer we're checking (starts at 1)
     * i: Index pointer for the input array
     * k: Remaining count of missing numbers to find
     */
    public int findKthPostiveLinear(int[] nums, int k) {
        int cur = 1;
        int i = 0;
        while (k > 0) {
            if (i >= nums.length || nums[i] != cur) { // exhausted all elements in the array
                // or cur is not the supposed number
                k--;  // Found a missing number
            } else {
                i++;  // Current number exists in array, move to next array element
            }
            cur++;    // Always move to next positive integer
        }
        return cur - 1;
    }

    /** variant, takes 3 days to complete the project, asking first day this project can be completed
     *  k = 3 return 8
     *  l  m      r
     *  4, 7, 9, 10
        0  2  3  3
     missing 5, 6, 8, 11
     */

    public int findFirstDay(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int missing = 0;
        int start = nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            missing = nums[mid] - mid - start;
            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // arr[r] + k - missing
        // arr[r] + k - arr[r] + r + arr[0]
        // k + r + arr[0]
        // 2 + 2 + 4
        return nums[0] + k + right;
    }
}
