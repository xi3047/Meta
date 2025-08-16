package string;

public class L14_LongestCommonPrefix {
    /*
    Use first string as prefix
    look at rest of words, if not match, take one ch from the end try to match again
    if not match return empty string
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for  (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
