package array;

public class L1060_MissingElementInSortedArray {
    /**
     * Binary Search to find where the k-th missing number lies
     * Missing Count Formula: nums[mid] - mid - nums[0] calculates missing numbers up to index mid
     * Final Formula: nums[0] + k + right gives the k-th missing number after the rightmost valid position
     * k = 3
     *                     r  l
     * index:           0  1  2  3
     * nums:            4  7  9  10
     * missingCount:    0  2  3  3
     * missingNumber:   5  6  8  11
     *
     */
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int missing = 0;
        int start = nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Calculate how many numbers are missing up to nums[mid]
            // Formula: nums[mid] - nums[0] - mid
            // This gives us the count of missing numbers between nums[0] and nums[mid]
            missing = nums[mid] - mid - start;

            if (missing < k) {
                // Not enough missing numbers on the left half
                // The k-th missing number is in the right half
                left = mid + 1;
            } else {
                // We have k or more missing numbers on the left half
                // The k-th missing number is in the left half or at mid
                right = mid - 1;
            }
        }
        // After binary search:
        // right points to the largest index where missing count < k
        // The k-th missing number comes after nums[right]

        // Formula derivation:
        //   nums[right] + (k - missing_at_right)
        // = nums[right] + k - (nums[right] - right - nums[0])
        // = nums[right] + k - nums[right] + right + nums[0]
        // = k + right + nums[0]
        return nums[0] + k + right;
    }

    /**
     * 4 7 9 10   k = 3
     * 5 6 8 11
     * @param nums
     * @param k
     * @return
     */
    public int missingElementLinear(int[] nums, int k) {
        int n = nums.length;

        // Iterate through adjacent pairs to find missing numbers
        for (int i = 1; i < n; i++) {
            // Calculate how many numbers are missing between nums[i-1] and nums[i]
            int gap = nums[i] - nums[i-1] - 1;

            if (k <= gap) {
                // The k-th missing number is in this gap
                // It's the (k-1)th number after nums[i-1]
                return nums[i-1] + k;
            }

            // Reduce k by the number of missing elements we've passed
            k -= gap;
        }

        // If we reach here, the k-th missing number is beyond the array
        // It's the k-th number after the last element
        return nums[n-1] + k;
    }
}
