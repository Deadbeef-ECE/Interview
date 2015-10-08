public class Solution {
    // O(1) space(without counting recursion stack)
    // O(logn) space(couting recursion stack)
    // O(1) time 
    // or O(logn) but logn is constant here, maximum is logMAX_VALUE)
    public double myPow(double x, int n) {
        if(x == 0)  return 0;
        if(n < 0)
            return 1.0/pow(x, n);
        return pow(x, n);
    }
    
    private double pow(double x, int n){
        if(n == 0)  return 1;
        
        double ret = pow(x, n/2);
        if(n % 2 == 0)
            return ret*ret;
        else
            return ret*ret*x;
    }
    // iteration & bit manipulate
    public double myPow(double x, int n) {
        double ret = 1.0;
        double p = x;
        long m = (n >= 0) ? n : -n;
        while(m > 0) {
            if ((m & 0x1) == 1) {
                ret *= p;
            }
            m >>= 1;
            p *= p;
        }
        return (n >= 0) ? ret : 1.0/ret;
    }
}