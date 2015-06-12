import java.util.LinkedList;
import java.util.List;

// input array of number {1,2,3,4,5,6} 
// return number of array {2*3*4*5*6, 1*3*4*5*6,1*2*4*5*6,1*2*3*5*6,1*2*3*4*6,1*2*3*4*5 }
// 要求 不允许用除法。
       
public class ComputeArray {
	// O(n^2) time
	public static List<Integer> getResult(int[] num) {
		List<Integer> ret = new LinkedList<Integer>();
		for (int i = 0; i < num.length; i++) {
			int value = 1;
			for (int j = 0; j < num.length; j++) {
				value *= i == j ? 1 : num[j];
			}
			ret.add(value);
		}
		return ret;
	}
	// O(n) time
//	public static List<Integer> getResult2(int[] num) {
//		List<Integer> ret = new LinkedList<Integer>();
//		for (int i = 0, j = 0; i < num.length; i++,j++) {
//			int value = 1;
//			if(num[i] != num[j]){
//				value *= num[i];
//			}
//			ret.add(value);
//		}
//		return ret;
//	}
	public static void main(String[] args){
		int[] num = {1,2,3,4,5,6};
		List<Integer> ret = getResult(num);
		//List<Integer> ret2 = getResult2(num);

		for(Integer n : ret){
			System.out.print(n+" ");
		}
		System.out.println();
//		for(Integer n : ret2){
//			System.out.print(n+" ");
//		}
//		System.out.println();
	}
}
