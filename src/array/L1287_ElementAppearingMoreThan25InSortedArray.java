package array;

public class L1287_ElementAppearingMoreThan25InSortedArray {
    /*
      Binary Search
      SPlit the array into 4 equal partitions
      if element appeared more than 1/4, it must span more than one sector
      check first element of first 3 sector and find their window size
      if their count > 1/4 return it
     */
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] sector = {n/4, n/2, 3*n/4};
        for (int i : sector) {
            int cand = arr[i];
            int first = findFirst(arr, cand);
            int last = findLast(arr, cand);

            if (last - first  + 1 > n / 4) return cand;
        }
        return -1;
    }
    private int findFirst(int[] arr, int cand) {
        int left = 0, right = arr.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= cand){
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private int findLast(int[] arr, int cand) {
        int left = 0, right = arr.length -1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= cand){
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
