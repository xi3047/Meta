package array;

public class L670_MaximumSwap {
    /**
     * 2736 -> 7236
     * from left to right, we swap as soon we find there is a larger number behind cur index
     * e.g.  4 2 1 4 3 ,  when we at 2, we need to swap 4 with it, to get largest
     * Track last occurrence of every digit
     */
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int[] lastIndex = new int[10];

        for (int i = 0; i < arr.length; i++) {
            lastIndex[arr[i] - '0'] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 9; j > (arr[i] - '0'); j--) {
                if (lastIndex[j] > i) {
                    char temp = arr[i];
                    arr[i] = arr[lastIndex[j]];
                    arr[lastIndex[j]] = temp;
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
}
