// 3.
// 找出一个 int 的 binary 表示里有多少个 1

public class Q003_NumberOf1Bits {
	public static int NumberOfOnes(int n){
        int ret = 0;
        while(n != 0){
            ret++;
            n = n & (n - 1);
        }
        return ret;
    }
	
	public static void main(String[] args){
		test(101);
		test(999922);
		test(2435234);
		test(0);
		test(Integer.MAX_VALUE);
		test(Integer.MIN_VALUE);
	}
	
	private static void test(int n){
		System.out.println("Input: " + n + " ("+Integer.toBinaryString(n) + ")");
		System.out.println(n + " has " + NumberOfOnes(n) + " 1s\n");
	}
}
