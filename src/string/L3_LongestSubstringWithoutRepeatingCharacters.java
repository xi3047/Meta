package string;

import java.util.HashSet;
import java.util.Set;

public class L3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int longest = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            while (set.contains(cur)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }
}
