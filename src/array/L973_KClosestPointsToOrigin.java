package array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L973_KClosestPointsToOrigin {
    /**
     * Quick select solution
     */
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k - 1);
        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private void quickSelect(int[][] points, int left, int right, int k) {
        int pivotDistance = distance(points[right]);
        int split = left;
        for (int i = left; i < right; i++) {
            if (distance(points[i]) < pivotDistance) {
                swap(points, i, split);
                split++;
            }
        }
        swap(points, split, right);
        if (split == k) return;
        else if (split < k) quickSelect(points, split + 1, right, k);
        else quickSelect(points, left, split - 1, k);
    }

    private int distance(int[] point) {
        int a = Math.abs(point[0]);
        int b = Math.abs(point[1]);
        return a * a + b * b;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    /**
     * Heap solution
     */
    public int[][] kClosestHeap(int[][] points, int K) {
        Map<int[], Integer> map = new HashMap<>();
        for (int[] point : points) {
            int distance = distance(point);
            map.put(point, distance);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) maxHeap.poll();
        }

        int[][] res= new int[maxHeap.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = maxHeap.poll();
        }

        return res;
    }

}
