// 14.
// given an integer ,find 最小长度 minlen 的 expression of integer, minlen 定义为多少个完 全平方数相加
// 例如 14 = 1 + 4 + 9, minlen = 3
//
// follow up: how to optimize-- 没时间了

public class Q014_ExpressionOfInteger {
	// logn solution:
	public static int minLen(int n){
		int cnt = 0;
		int t = 1;
		if(Math.sqrt(n) % 1 == 0)
			return 1;
		while(n > 0){
			t = 1;
			while(n > 2*Math.pow(t, 2)){
				t++;
			}
			n -= Math.pow(t, 2);
			cnt++;
			//System.out.println("t:"+t);
		}
		return cnt;
	}
	
	// *******************************************
	// TODO: Optimization ?????? I don't think so
	// *******************************************
	
	public static void main(String [] args){
		System.out.println(minLen(8));  //4+4     (should be 2)
		System.out.println(minLen(13)); //4+9     (should be 2)
		System.out.println(minLen(14)); //1+4+9   (should be 3)
		System.out.println(minLen(15)); //1+1+4+9 (should be 4)
		System.out.println(minLen(25)); //25      (should be 1)
		System.out.println(minLen(9));  //9  	  (should be 1)
		System.out.println(minLen(81)); //81 	  (should be 1)  
	}
}
