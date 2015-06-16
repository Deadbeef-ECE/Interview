public class Solution {
    // you need treat n as an unsigned value
    // O(1) space, O(1) time
    public int reverseBits(int n) {
        int ret = 0;
        for(int i = 0; i < 32; i++){
            if((n & (1 << i)) != 0)
                ret |= (1 << (31-i));
        }
        return ret;
    }
}