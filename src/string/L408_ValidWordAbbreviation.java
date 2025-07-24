package string;

public class L408_ValidWordAbbreviation {

    /**
     * Problem: Check if word is same as the abbreviation
     Explanation: two pointers for each string, i , j
     if Digit then compute num and move i pointers num ahead,
     if Character then check if the same

     Corner case: leading zero, i moves above word length
     */
    public static boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (Character.isDigit(abbr.charAt(j))) {
                int num = 0;
                if (abbr.charAt(j) == '0') return false;
                while (j < n && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += num;
                if (i > m) return false;
            } else {
                if (word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            }
        }
        return i == m && j == n;
    }

    public static void main(String[] args) {
        boolean res = validWordAbbreviation("apple", "a2le");
        System.out.println(res);
        //System.out.println(sol.validWordAbbreviation("apple", "a2le"));
        //System.out.println(validWordAbbreviation2("substitution", "s10n"));
    }


}
