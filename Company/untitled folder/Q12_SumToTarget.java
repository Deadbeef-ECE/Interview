// 12.
// 给一个 int[] array, 和一个 int target
// e.g. arr = {1,5,0,6}, target = 21; 
// 问是否存在某种分法把 array 分成几部分, 每部分看成一个 int, 这几部分加起来等于 target. 
// e.g. {1,5}{0}{6}, 三部分加起来是 21
//      {1,5}{0,6},	也是 21
//      target = 25 则 false

import java.util.LinkedList;
import java.util.List;

public class Q12_SumToTarget{
	// solution:
	// @author: Lei Wang
	public static boolean findTarget(int[] arr, int target) {
		if(arr == null || arr.length == 0)
			return false;
		boolean[] found = {false};
		rec(arr, target, 0, 0, found);
		return found[0];
	}
	
	private static void rec(int[] arr, int target, int start, int prev, boolean[] found){
		if (found[0] == true || prev > target)
			return;
		
		if (start == arr.length && prev == target) {
			found[0] = true;
			return;
		}

		for (int i = start; i < arr.length; i++) {	
			int num = 0;
			for (int j = start; j <= i; j++)
				num = num * 10 + arr[j];
			rec(arr, target, i + 1, prev + num, found);
		}
	}
	
	// My follow up 
	// Return all possible combinations
	// based on solution 2:
	public static List<List<Integer>> AllSumToTarget(int[] nums, int target){
		List<List<Integer>> ret = new LinkedList<List<Integer>> ();
		if(nums == null || nums.length == 0)
			return ret;
		int sum = 0;
		List<Integer> path = new LinkedList<Integer>();
		doDFS(0, sum, nums, target, path, ret);
		return ret;
	}
	
	private static void doDFS(int start, int sum, int[] nums, int target, 
			List<Integer> path, List<List<Integer>> ret){
		if(start > nums.length || sum > target)
			return;

		if(start == nums.length && sum == target){
			ret.add(new LinkedList<Integer>(path));
			return;
		}

		for(int i = start; i < nums.length; i++){
			int num  = 0;
			for(int j = start; j <= i; j++)
				num = num * 10 + nums[j];
			path.add(num);
			doDFS(i + 1, sum + num, nums, target, path, ret);
			path.remove(path.size() - 1);
		}
	}
	
	public static void main(String[] args){
		int[] nums = {1, 5, 1, 6, 0, 1};
		test(nums, 752);
		test(nums, 1517);
		test(nums, 14);
		test(nums, 51602);
		test(nums, 12);
	}
	
	private static void test(int[] nums, int target){
		System.out.print("Input array: [");
		for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i]+" ");
		System.out.print("]\nTarget: " + target + "\n");
		
		boolean ret1 = findTarget(nums, target);
		//boolean ret2 = SumToTarget(nums, target);
		System.out.println("Can sum to target "+ target +" ? "+ ret1);
		if(ret1 == false)	return;
		
		System.out.println("All possible solutions: ");
		List<List<Integer>> sol = AllSumToTarget(nums, target);
		for(List<Integer> list : sol){
			for(int i = 0; i < list.size(); i++){
				System.out.print(list.get(i));
				if(i != list.size() - 1)
					System.out.print(" + ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
