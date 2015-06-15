public class Solution {
	// O(1) space, O(log5n) time
    public int trailingZeroes(int n) {
        int ret = 0;
        while(n > 0){
            n = n / 5;
            ret += n;
        }
        return ret;
    }
}