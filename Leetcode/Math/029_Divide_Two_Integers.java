public class Solution {
	// O(1) space, O(logn) time
	public int divide(int dividend, int divisor) {
		boolean isNeg = (dividend > 0 && divisor < 0)
			|| (dividend < 0 && divisor > 0);
		if(dividend == Integer.MIN_VALUE && divisor == -1){
			return Integer.MAX_VALUE;
		}
		long absDividend = Math.abs((long) dividend);
		long absDivisor = Math.abs((long) divisor);
		if(absDividend < absDivisor)    return 0;
		long sum = 0, pow = 0;
		int ret = 0;
		
		while (absDividend >= absDivisor) {
			pow = 1;
			sum = absDivisor;
			while(sum + sum <= absDividend){
			    sum += sum;
			    pow += pow;
			}
			absDividend -= sum;
			ret += pow;
		}
		return isNeg ? -ret : ret;
	}
}