package array;

public class L55_JumpGame {
    public boolean canJump(int[] nums) {
        int furthestJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > furthestJump) return false;
            furthestJump = Math.max(furthestJump, i + nums[i]);
        }
        return true;
    }
}
