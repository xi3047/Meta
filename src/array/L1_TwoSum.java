package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                res[0] = i;
                res[1] = map.get(complement);
            }
            map.put(nums[i], i);
        }
        return res;
    }

    /**
     * Variant 1: true or false
     */
    public boolean twoSum2(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (set.contains(complement)) return true;
            set.add(num);
        }
        return false;
    }

    /**
     * Variant 2: Given an array of pairs dominoes and an integer target
     * return the number of unique domino pairs [a1, a2] and [b1, b2]
     * where a1 + b1 = target && a2 + b2 = target
     */
    public int twoSum3(int[][] pairs, int target) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] pair : pairs) {
            int x = pair[0], y = pair[1];
            int cx = target - x, cy = target - y;

            String cKey = cx + "," + cy;
            if (map.containsKey(cKey)) {
                count += map.get(cKey);
            }

            String currentKey = x + "," + y;
            map.put(currentKey, map.getOrDefault(currentKey, 0) + 1);
        }

        return count;
    }
}
