package design_math;

public class L9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reversed = 0;
        int copyX = x;
        while (copyX != 0) {
            reversed = reversed * 10 + copyX % 10;
            copyX /= 10;
        }
        return reversed == x;
    }
}
