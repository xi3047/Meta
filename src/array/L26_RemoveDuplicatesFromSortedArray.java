package array;

public class L26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int split = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[split] = nums[i];
                split++;
            }
        }
        return split;
    }
}
