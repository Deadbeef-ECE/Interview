public class SelectionSort {
	public static void sort(int[] arr){
		int len = arr.length;
		for(int i = 0; i < len; i++){
			int min = i;
			for(int j = i+1; j < len; j++){
				if(arr[j] < arr[min])
					min = j;
			}
			swap(arr, i, min);
		}
	}
	
	public static void swap(int[] arr, int n, int m){
		int temp = arr[n];
		arr[n] = arr[m];
		arr[m] = temp;
	}
	// advantage: 数据移动次数在所以排序算法中最少，为N
	// disadvantage: 无论数组是否有序，时间一样，因为有序数组就是自己和自己换
}
