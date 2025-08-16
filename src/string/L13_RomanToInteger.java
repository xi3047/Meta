package string;

import java.util.HashMap;
import java.util.Map;

public class L13_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = romanMap.get(s.charAt(i));
            if (cur < prev) {
                total -= cur;
            } else {
                total += cur;
            }
            prev = cur;
        }
        return total;
    }
}
