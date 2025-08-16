package array;

import java.util.ArrayList;
import java.util.List;

public class L986_IntervalListIntersection {
    /**
     * use two pointers for each list
     * there is only overlap is start max <= end min
     * move to next interval in that list based on end
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j= 0;
        while (i < firstList.length && j < secondList.length) {
            int startMax = Math.max(firstList[i][0], secondList[j][0]);
            int endMin = Math.min(firstList[i][1], secondList[j][1]);

            if (startMax <= endMin) {
                res.add(new int[]{startMax, endMin});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] ans = new int[res.size()][];
        for (int k = 0; k < ans.length; k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }
}
