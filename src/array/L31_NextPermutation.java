package array;

public class L31_NextPermutation {
    /*
     Find first valley element from right, so that we can swap a bigger number to make it bigger
     once found, we can find the next largest and swap with it
     array after valley is in increasing order,
     we have to reverse this order to make rest smallest so that it is next permutation
     corner case: if valley is -1 it means array itself is in increasing order (max number)
           meaning we just have to reverse to get the smallest
     */
    public void nextPermutation(int[] nums) {
       int n = nums.length;
       int i = n - 2;
        // Step 1: Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // Step 2: If found, go from end again and
        // find just larger element to swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
       // reverse rest of element in increasing order
       reverse(nums, i + 1, n -1 );
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    /**
     * Variant: Previous permutation
     */
    public void previousPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find first increasing element from the end
        while (i >= 0 && nums[i] <= nums[i + 1]) {
            i--;
        }
        // Step 2: If found, find just smaller element to swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] >= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // Step 3: Reverse suffix in descending order
        reverse(nums, i + 1, n - 1);
    }

}
