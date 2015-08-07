// 32.
// 给两个 sorted array, 返回它们两个包含的相同元素,
// 比如[2, 3, 4], [1, 2, 3, 5] 返回[2, 3]
// follow up 是如果其中一个 array 特别长一个比较短怎么做

import java.util.HashSet;
import java.util.Set;

public class Q032_CommonElementsInTwoArrays {
	// O(n) time, n is the longer array
	public static int[] find(int[] a, int[] b){
		if(a == null || a.length == 0)
			return new int[0];
		if(b == null || b.length == 0)
			return new int[0];
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> com = new HashSet<Integer>();
		for(int i: b) // set used for shorter arr to save time
			set.add(i);
		for(int i: a){
			if(set.contains(i))
				com.add(i);
		}
		int[] ret = new int[com.size()];
		int index = 0;
		for(int i : com)
			ret[index++] = i;
		return ret;
	}
	
	// follow up
	// 思路: 边比较边判断是否已经把short array比较完了
	// O(n) time, n is the longer array, but can save time in many cases
	public static int[] findFaster(int[] a, int[] b){
		if(a == null || a.length == 0)
			return new int[0];
		if(b == null || b.length == 0)
			return new int[0];
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> com = new HashSet<Integer>();
		for(int i: b) // set used for shorter arr to save time
			set.add(i);
		for(int i: a){
			if(set.contains(i)){
				com.add(i);
				// REMOVE finded one to save time
				set.remove(i);
				if(set.size() == 0){
					System.out.println("finished finding");
					break;
				}
			}
		}
		int[] ret = new int[com.size()];
		int index = 0;
		for(int i : com)
			ret[index++] = i;
		return ret;
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,6,7,8,8,8,9,10};
		int[] b = {2,3,6,6,7};
		int[] b2 ={11,12};
		test(a, b);	
		test(a, b2);
	}
	
	public static void test(int[] a, int[] b){
		System.out.println("a:");
		for(int i : a)
			System.out.print(i+" ");
		
		System.out.println("\nb:");
		for(int i : b)
			System.out.print(i+" ");
		
		int[] ret = findFaster(a, b);
		System.out.println("\ncommon:");
		for(int i : ret)
			System.out.print(i+" ");
		System.out.println("\n");
	}
}
