// 10.
// 求 array 里 unordered pair的数量(前一个数比后一个数大)
// e.g.:
// {1, 3, 2} 有一个 (3, 2),
// {1, 2, 3} 没有
// {3, 2, 1} 有三个 (3, 2) (3, 1) (2, 1)

import java.util.LinkedList;
import java.util.List;

public class Q10_UnsortedPaitInArray {
	// brute force: O(n^2) time
	public static List<List<Integer>> BruteFoce(int[] arr){
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		for(int i = 0 ; i < arr.length - 1; i++){
			for(int j = i + 1; j < arr.length; j++){
				if(arr[i] > arr[j]){
					List<Integer> pair = new LinkedList<Integer>();
					pair.add(arr[i]); pair.add(arr[j]);
					ret.add(pair);
				}
			}
		}
		return ret;
	}
	
	// **************************************************
	// TODO: merge sort solution OR segment tree solution
	// **************************************************
	
	public static void main(String[] args){
		int[] arr1 = {4, 3, 2, 1};
		int[] arr2 = {8,7,2,6,5,9,3};
		int[] arr3 = {1,2,3,4,5,6,7};
		test(arr1);
		test(arr2);
		test(arr3);
	}
	
	private static void test(int[] arr){
		System.out.println("input: ");
		System.out.print("[");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
			if(i != arr.length - 1) 
				System.out.print(",");
		}
		System.out.print("]");
		List<List<Integer>> ret = BruteFoce(arr);
		System.out.println("\nFirst Blood: brute-force (" + ret.size() + ")");
		for(List<Integer> pair : ret){
			System.out.print("["+ pair.get(0)+","+ pair.get(1)+"] ");
		}
		System.out.println("\n");
	}
}
