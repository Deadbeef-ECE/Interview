public class Solution {
    // O(1) space, O(1) time (integer length/size is constant)
    public int reverse(int x) {
        if(x == 0)
            return 0;
        int r = 0;
        while(x != 0){
            if(r > Integer.MAX_VALUE/10 || r < Integer.MIN_VALUE/10)
                return 0;
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
}