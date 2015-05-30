public class ShellSort {
	public static void sort(int[] arr){
		int len = arr.length;
		int h = 1;
		while(h < len/3){
			h = 3*h+1;
		}
		System.out.println("len: "+ len + " h:" + h);
		while(h >= 1){
			for(int i = h; i < len; i++){
				for(int j = i; j >= h && arr[j] < arr[j-h]; j -= h){
					swap(arr, j, j-h);
				}
			}
			h /= 3;
		}
	}
	
	public static void swap(int[] arr, int n, int m){
		int temp = arr[n];
		arr[n] = arr[m];
		arr[m] = temp;
	}
}
