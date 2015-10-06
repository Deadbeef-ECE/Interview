public class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        long left, right, pos = 1;
        if(n < 1)   return 0;
        while(n >= pos){
            left = n / pos;
            right = n % pos;
            long remain = left % 10;
            if(remain == 1)
                ones += (left/10) * pos + right + 1;
            else if(remain > 1)
                ones += (left/10 + 1) * pos;
            else
                ones += (left/10) * pos;
            pos *= 10;
        }
        return ones;
    }
}