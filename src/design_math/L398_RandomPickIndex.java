package design_math;

import java.util.Random;

public class L398_RandomPickIndex {
    int[] nums;
    Random rand;

    public L398_RandomPickIndex(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    public int pick(int target) {
        int count = 0;      // Number of times we've seen 'target'
        int result = -1;    // The selected index (to be updated)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) {
                    result = i;
                }   // We've found another occurrence of 'target'
            }

        }
        return result;
    }
}
