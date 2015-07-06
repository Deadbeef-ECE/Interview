public class Solution {
	// O(1) space, O(1) time
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)    return false;
        return (n & (n - 1)) == 0;
    }
}