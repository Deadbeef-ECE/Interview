import java.util.ArrayDeque;
import java.util.Deque;

/*
 * sliding windows (given an array of n numbers and a window width of k, 
 * return a new array with the minimum value in each window)
 * e.g: a = 1,2,3,-1,5,6,7
 * k = 3 return : 1,-1,-1,-1,5,6,7;
 */

public class FindMinORMaxInSlidingWindow {
	// O(n) time
	public static int[] FindMinInWindow(int[] arr, int k){
		if (arr == null || arr.length == 0 || k <= 1) {
			return arr;
		}
		/* First K section*/
		int[] res = new int[arr.length];
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && arr[i] <= arr[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		/* The rest k - length section*/
		for (int i = k; i < arr.length; i++) {
			res[i-k] = arr[dq.peekFirst()];
			while (!dq.isEmpty() && arr[i] <= arr[dq.peekLast()])
				dq.pollLast();
			// Remove the elements which are out of this window
			while (!dq.isEmpty() && dq.peekFirst() <= i - k)
				dq.pollFirst();
			dq.addLast(i);
		}
		/* Rest */
		for (int i = arr.length - k; i < arr.length; i++)
			res[i] = arr[dq.peekFirst()];
		return res;
	}
    
	public static int[] FindMaxInWindow(int[] arr, int k){
		if (arr == null || arr.length == 0 || k <= 1) {
			return arr;
		}
		/* First K section*/
		int[] res = new int[arr.length];
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for (int i = 0; i < k; i++) {
			while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		/* The rest k - length section*/
		for (int i = k; i < arr.length; i++) {
			res[i-k] = arr[dq.peekFirst()];
			// need to add i
			while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
				dq.pollLast();
			// Remove the elements which are out of this window
			while (!dq.isEmpty() && dq.peekFirst() <= i - k)
				dq.pollFirst();
			dq.addLast(i);
		}
		/* Rest */
		for (int i = arr.length - k; i < arr.length; i++)
			res[i] = arr[dq.peekFirst()];
		return res;
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,0,3,8,6,7,9,4};
		printArr(arr);
		int[] ret1 = FindMinInWindow(arr, 3);
		printArr(ret1);
		int[] ret2 = FindMaxInWindow(arr, 3);
		printArr(ret2);
	}
	
	private static void printArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
