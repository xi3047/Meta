package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L560_SubArrayEqualsK {
    /*
       with negative numbers
       keep a map to track currentSum and its frequency
       iterate through the array, check if there are any subarray plus k that adds to current sum
       e.g if there are 2 subarray with sum of 5,  and k is 3, current sum is 8
       we know from index of subarray of sum of 5 to current, cur subarray is 3.
       we add that to final result
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int count = 0;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (sumMap.containsKey(currentSum - k)) {
                count += sumMap.get(currentSum - k);
            }
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0 ) + 1);
        }
        return count;
    }

    /**
     * Variant 1: return true if there is one subarray whose sum equals to k
     * return as soon as we find complement + k = current sum
     * use a set to store current sum
     * e.g. {1, 1, 3} k = 3, set = 1 , 2, 5
     */
    public boolean subArrayFound(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            int complement = currentSum - k;
            if (set.contains(complement)) {
                return true;
            }
            set.add(currentSum);
        }
        return false;
    }
    /**
     * Variant 2 : only positive integers
     * sliding window, expands to include elements,
     * contracts left with cur sum is greater than k
     */
    public boolean subArray(int[] nums, int k) {
        int sum = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            if (sum == k) return true;
            right++;
        }
        return false;
    }
}
