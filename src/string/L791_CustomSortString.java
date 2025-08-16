package string;

public class L791_CustomSortString {
    /**
     * Step 1 : count frequency in string s
     * Step 2 : go through order and build res string with freq
     * Step 3 : append the rest from string s
     */
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (freq[c - 'a']-- > 0) {
                res.append(c);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (freq[c - 'a']-- > 0) {
                res.append(c);
            }
        }
        return res.toString();
    }
}
