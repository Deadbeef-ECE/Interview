public class Solution {
    // you need to treat n as an unsigned value
    // Shift 32 times:
    // O(1) space, O(1) time
    public int hammingWeight(int n) {
        int ret = 0;
        for(int i = 0; i < 32; i++){
            if((n & (1 << i)) != 0)
                ret++;
        }
        return ret;
    }

    // Eliminate the rightmost '1':
    // O(1) space, O(1) time
    public int hammingWeight2(int n) {
        int ret = 0;
        while(n != 0){
            ret++;
            n = n & (n - 1);
        }
        return ret;
    }
}