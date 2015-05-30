public class InsertionSort {
	public static void sort(int[] arr){
		int len = arr.length;
		for(int i = 1; i < len; i++){
			// 从后往前遍历，如果一直小，就交换
			for(int j = i; j > 0 && arr[j] < arr[j-1]; j--)
				swap(arr, j, j-1);
		}
	}
	
	public static void swap(int[] arr, int n, int m){
		int temp = arr[n];
		arr[n] = arr[m];
		arr[m] = temp;
	}
	// advantage: 对于接近sorted的数组，运行时间短，但很稳定
	// disadvantage: 逆序数组时间长
}
