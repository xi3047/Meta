package array;

import java.util.*;

public class L1424_DiagonalTraverse2 {
    /**
     * Since every cell on the diagonals will have same key i + j
     * construct a Map of diagonals and their values
     * Go through the map and reverse each diagonals
     * add to result array
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> diagonals = new HashMap<>();
        int maxKey = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                diagonals.computeIfAbsent(i + j , k -> new ArrayList<>()).add(nums.get(i).get(j));
                maxKey = Math.max(i + j, maxKey);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= maxKey; i++) {
            List<Integer> list = diagonals.get(i);
            for (int k = list.size() - 1; k >= 0; k--) {
                ans.add(list.get(k));
            }
        }
        int [] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;

    }
}
