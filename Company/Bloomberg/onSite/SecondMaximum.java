package onsite;

import java.util.PriorityQueue;

//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=132633&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
public class SecondMaximum {
	// Find the second maximum element in an unsorted array
	// O(1) space, O(n) time
	public static int findSecondMaximum(int[] arr){
		if(arr == null || arr.length < 2) 	
			return Integer.MIN_VALUE;
		int Max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > Max){
				secondMax = Max;
				Max = arr[i];
			}
			else if(arr[i] > secondMax){
				secondMax = arr[i];
			}
		}
		return secondMax;
	}
	// Flow up: find the Kth largest element in an unsroted array
	// solution 1: minPQ
	// O(k) space and O(nlogk) time 
	public static int findKthMaxWithPQ(int[] arr, int k){
		if(arr == null || k > arr.length)	
			return Integer.MIN_VALUE;
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k+1);
		for(int i = 0; i < arr.length; i++){
			minHeap.offer(arr[i]);
			if(minHeap.size() > k)
				minHeap.poll();
		}
		return minHeap.peek();
	}
	
	// solution 2: QuickSelect
	// O(1) space
    // O(n) time(average case), O(n^2) time(worest case)
	public static int findKthMaxWithQuickSelect(int[] arr, int k){
		if(arr == null || k > arr.length)
			return Integer.MIN_VALUE;
		return getKth(arr, arr.length - k + 1, 0, arr.length - 1);
	}
	private static int getKth(int[] arr, int k, int start, int end){
		int pivotal = arr[end];
		int l = start, r = end;
		while(true){
			while(arr[l] < pivotal && l < r)
				l++;
			while(arr[r] >= pivotal && l < r)
				r--;
			if(l == r)	break;
			xchg(arr, l, r);
		}
		xchg(arr, l, end);
		if(k == l + 1)	
			return pivotal;
		if(k > l + 1)	
			return getKth(arr, k, l+1, end);
		else	
			return getKth(arr, k, start, l-1);
	}
	private static void xchg(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,6,7,8,9};
		int ret = findSecondMaximum(arr);
		System.out.println(ret);
		int[] arr2 = {9,8};//,8,7,6,5,4,3,2,1,4,5,6,7};
		ret = findSecondMaximum(arr2);
		System.out.println(ret);
		int[] arr3 = {9,1,2,7,6,5,4,3,2,1,4,5,6,7};
		ret = findKthMaxWithPQ(arr3, 3);
		System.out.println(ret);
		int[] arr4 = {9,1,2,7,6,5,4,3,2,1,4,5,6,7};
		ret = findKthMaxWithQuickSelect(arr4, 3);
		System.out.println(ret);

	}
}
