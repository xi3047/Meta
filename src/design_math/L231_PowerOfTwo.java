package design_math;

public class L231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n>0 && (n&(n-1)) ==0);
    }
}
