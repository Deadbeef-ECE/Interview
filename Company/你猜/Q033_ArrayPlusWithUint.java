// 33.
// 给一个array表示的数字,比如['1','2','3'] 和一个unsignedint, 
// 返回它们的加和,返回的也要是一个 array

// 个人理解array是数字, 可以很大很大, 所以转换成 String 可以防止 overfollow
public class Q033_ArrayPlusWithUint {
	public static int[] plus(int[] a, int b){
		StringBuilder Asb = new StringBuilder();
		for(int i = 0; i < a.length; i++)
			Asb.append(a[i]);
		String A = Asb.toString();
		String B = Integer.toString(b);
		
		int maxLen = Math.max(A.length(), B.length());
		int[] ret = new int[maxLen + 1];
		int carry = 0, index = maxLen;
		for(int i = A.length() - 1, j = B.length() - 1; i >= 0 || j >= 0; i--, j--){
			int digitA = i < 0 ? 0 : Character.getNumericValue(A.charAt(i));
			int digitB = j < 0 ? 0 : Character.getNumericValue(B.charAt(j));
			int sum = digitA + digitB + carry;
			carry = sum / 10;
			ret[index--] = sum % 10;
		}
		if(carry == 1)
			ret[0] = 1;
		else {
			int[] temp = new int[maxLen];
			for(int i = 1, j = 0; i <= maxLen; i++){
				temp[j++] = ret[i];
			}
			return temp;
		}
		return ret;
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,3,2,1,9,9,0};
		int b = 431123;
		test(a, b);
	}
	
	private static void test(int[] a, int b){
		System.out.print("input array: ");
		for(int digit : a)
			System.out.print(digit+" ");
		System.out.println("\nb: " +b );
		int[] sumArr = plus(a, b);
		System.out.print("\nOutput array: ");
		for(int digit : sumArr)
			System.out.print(digit+" ");
		System.out.println("\n");
	}
}
