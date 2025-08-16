package string;

public class L5_LongestPalindromicSubstring {

    /**
     * For every position we try to expand from there
     * extends returns the longest palindrome it can find centered at that index
     * Time: O(^2)
     * Space: O(n)
     */
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i);         // Try odd-length palindrome
            String s2 = extend(s, i, i + 1); // Try even-length palindrome
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }

    private String extend(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) break;
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
