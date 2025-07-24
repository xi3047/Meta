package array;
import java.util.*;

public class L56_MergeIntervals {
    /**
     * Sort array based on start (Clarify if it's sorted)
     * when cur start > last end, there is no overlap
     * Case 1: if empty or not overlapping, add new interval
     * Case 2: if overlapping, change last interval's end to max of the two
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            if (list.isEmpty() || interval[0] > list.get(list.size() - 1)[1]) {
                list.add(interval);
            } else {
                list.get(list.size()-1)[1] = Math.max(interval[1], list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}