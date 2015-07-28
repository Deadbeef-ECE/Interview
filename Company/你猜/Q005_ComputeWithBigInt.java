// 5.
// 实现任意大整数的加减乘除

import java.math.BigInteger;

public class Q005_ComputeWithBigInt {
	// Use BigInteger Class
	public static String compute(String a, String b, char op){
		BigInteger A = new BigInteger(a);
		BigInteger B = new BigInteger(b);
		switch (op) {
		case '+':
			A = A.add(B);
			break;
		case '-':
			B = B.negate();
			A = A.add(B);
			break;
		case '*':
			A = A.multiply(B);
			break;
		case '/':
			if(B.equals(new BigInteger("0"))){
				System.out.print("Are you fucking kidding with me? = ");
				return B.toString();
			}
			A = A.divide(B);
			break;
		default:
			break;
		}
		return A.toString();
	}
	
	// **************************************************
	// TODO: What if we cannot use BigInteger Class ??
	// **************************************************
	
	public static void main(String[] args){
		test("2321321312124141", "21321312124141", '-');
		test("2321321312124141", "0", '/');
		test("2321321312124141", "21321312124141", '*');
		test("2321321312124141", "21321312124141", '+');
	}
	
	private static void test(String a, String b, char op){
		System.out.print(a +" " + op + " " + b + " = ");
		System.out.print(compute(a, b, op)+"\n");
	}
}
