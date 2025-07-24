package string;

public class L680_ValidPalindromeII {
    /**
     *  Explanation:
     *  * - Use two pointers (`l` and `r`) to compare characters from both ends of the string.
     *  * - If characters match, move inward.
     *  * - On a mismatch, try skipping either the left or right character and check if the remaining substring is a palindrome.
     *  * - If either case returns true, the original string is valid under the "one removal" condition.
     *  *
     *  * Example:
     *  * Input:  "abca"
     *  * Output: true  // Removing 'b' -> "aca", or removing 'c' -> "aba", both are palindromes.
     */
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
