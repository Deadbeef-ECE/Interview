public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;
        long l = 1, r = num;
        while(l <= r){
            long mid = l + (r - l) / 2;
            long cur = mid * mid;
            if(cur > num)
                r = mid - 1;
            else if(cur < num)
                l = mid + 1;
            else
                return true;
        }
        return false;
    }
}