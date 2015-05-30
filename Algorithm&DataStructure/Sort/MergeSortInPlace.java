public class MergeSortInPlace {
	public static void sort(int[] arr){
		sort(arr, 0, arr.length-1);
	}
	
	private static void sort(int[] arr, int lo, int hi){
		if(lo >= hi)	return;
		int mid = lo + (hi - lo)/2;
		sort(arr, lo, mid);
		sort(arr, mid+1, hi);
		merge(arr, lo, mid, hi);
	}
	
	private static void merge(int[] arr, int lo, int mid, int hi){
		int i = lo;
		int j = mid+1;
		while(i < j && j <= hi){
			while(i < j && arr[i] <= arr[j]){
				i++;
			}
			int old_j = j-1;
			while(j <= hi && arr[j] < arr[i]){
				j++;
			}
			swapBlock(arr, i, old_j-1, j-1);
			i += (j - old_j);
		}
	}
	
	private static void swapBlock(int[] arr, int lo, int mid, int hi){
		reverse(arr, lo, mid);
		reverse(arr, mid+1, hi);
		reverse(arr, lo, hi);
	}
	
	private static void reverse(int[] arr, int start, int end){
		while(start < end){
			swap(arr, start++, end--);
		}
	}
	
	private static void swap(int[] arr, int m, int n){
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
}
