public class Solution {
	// ref: https://discuss.leetcode.com/topic/33536/a-summary-of-all-solutions-new-method-included-at-15-30pm-jan-8th
	// iteration
    public boolean isPowerOfThree(int n) {
        if(n > 1){
            while (n % 3 == 0)
                n /= 3;
        }
        return n == 1;
    }
    // recuersion 
    public boolean isPowerOfThree(int n) {
        return n > 0 && ( n == 1 || (n % 3 == 0 && isPowerOfThree(n/3)));
    }
    // 
}