package string;

public class L8_StringToInteger {
    public int myAtoi(String s) {
        // get ride of leading ' '
        int index = 0;
        int len = s.length();

        while (index < len && s.charAt(index) == ' ') index++;

        int sign = 1;
        if (index < len && s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (index < len && s.charAt(index) == '+')  {
            sign = 1;
            index++;
        }

        int result = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // check overflow
            // ----
            if (result > Integer.MAX_VALUE/10 ||
                    (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE % 10)
            ) {
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // -----
            result = 10 * result + digit;
            index++;
        }

        return sign * result;
    }
}
