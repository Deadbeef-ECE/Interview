public class Solution {
    // Binary Search:
    // O(1) space, O(1) time
    // or O(logn) time, but n is Integer.MAX_VALUE here
    // so O(logn) is O(logInteger.MAX_VALUE) as maximum which is constant
    public int mySqrt(int x) {
        long i = 0;
        long j = x/2 + 1;
        while(i <= j){
            long mid = (i + j)/2;
            if(mid*mid == x) return (int)mid;
            if(mid*mid > x)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return (int) j;
    }

    // Newton method:
    // O(I dont know) space, O(I dont know) time
    public int mySqrt(int x) {
        if (x == 0) {return 0;}
        if (x == 1) {return 1;}
        double x0 = 1;
        double x1;
        while(true){
            x1 = (x0 + x/x0)/2;
            if(Math.abs(x0-x1) < 1)
                return (int)x1;
            x0 = x1;
        }
    }
}