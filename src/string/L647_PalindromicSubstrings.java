package string;

public class L647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        // Consider every possible center of a palindrome
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            // Expand while it's a valid palindrome
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}
