// 34.                                 
// 写一个 shuffle 数组的算法,一个数组 A[],里面的数是无序的,
// 比如 A[]={1,2,3,7,3,2,5} shuffle 完之后,使之满足 A[0]<=A[1]>=A[2]<=A[3]..
// 比如一种可能的结果是 A[]={1,7,3,5,2,3,2}               {1,2,2,3, 3,5,7}

import java.util.Arrays;

public class Q034_ShuffleArray {
	// 思路: 先排序, 中间cut, 然后合并
	// O(nlogn + n) time, O(n) space
	public static int[] shuffle(int[] arr){
		int[] ret = new int[arr.length];
		Arrays.sort(arr);
		int cut = arr.length % 2 == 1 ? arr.length/2+1: arr.length/2;
		int start = 0;
		//System.out.println(" . "+arr.length + " , " + cut);
		for(int i = 0; i < arr.length; i++){
			if(i % 2 == 0)
				ret[i] = arr[start++];
			else
				ret[i] = arr[cut++];
		}
		return ret;
	}
	
	public static void main(String[] args){
		int[] arr = {1,1,1,1,1,1};
		test(arr);
		//            1 2 2 3|3 5 7
		int[] arr2 = {1,2,3,7,3,2,5};
		test(arr2);
		//			  1 2 3|3 5 7
		int[] arr3 = {1,2,3,7,3,5};
		test(arr3);
	}
	
	private static void test(int[] arr){
		System.out.println("input array: ");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		int[] ret = shuffle(arr);
		System.out.println("output array: ");
		for(int i = 0; i < ret.length; i++){
			System.out.print(ret[i]+" ");
		}
		System.out.println("\n");
	}
}
