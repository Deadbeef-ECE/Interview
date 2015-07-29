// 19.
// Given a sorted array of floats OR double?, find the index of the number closest to x:
// e.g:
// {1.2, 2.5, 9.3} x = 5, return 1
// leetcode 035 Search Insert Position 变形

public class Q019_FindClosestTarget {
	public static int find(float[] arr, float target){
		if(arr == null || arr.length == 0)
            return 0;
		int lo = 0, hi = arr.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(arr[mid] == target)
				return mid;
			if(arr[mid] > target)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		if(lo == 0)
			return 0;
		if(lo == arr.length)
			return lo - 1;
		float leftAbs = Math.abs(arr[lo-1] - target);
		float rightAbs = Math.abs(arr[lo] - target);
		return leftAbs < rightAbs ? lo - 1 : lo;
	}
	
	public static void main(String[] args){
		float[] arr = {1.2f, 2.5f, 9.3f, 10.0f, 12.4f};
		test(arr, 9.5f); // should be 9.3
		test(arr, 1.0f); // should be 1.2
		test(arr, 1.85f); // ...
		test(arr, 12.9f);
		test(arr, 10f);
	}
	
	private static void test(float[] arr, float target){
		System.out.print("Input :\n[");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
			if(i != arr.length - 1)
				System.out.print(", ");
		}
		System.out.print("]\n");
		System.out.println("Target is: " + target);
		int ret = find(arr, target);
		System.out.println("I found: " + arr[ret]+ " with index: " + ret);
		System.out.println();
	}
}
