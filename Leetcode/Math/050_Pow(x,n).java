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
}