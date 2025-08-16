package array;

import java.util.Arrays;

public class L16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int low = i +1, high = nums.length - 1;

            while (low < high) {
                int currentSum = nums[i] + nums[low] + nums[high];

                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }
                if (currentSum < target) {
                    low++;
                } else if (currentSum > target) {
                    high--;
                } else {
                    return target;
                }
            }
        }

        return closestSum;
    }
}
