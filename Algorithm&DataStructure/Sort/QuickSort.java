public class QuickSort {
	public static void quickSort(int[] A){
		quickSort(A, 0, A.length-1);
	}
	public static void quickSort(int[] A, int lo, int hi){
		if(hi <= lo)	return;
		int j = partition(A, lo, hi);
		quickSort(A, lo, j-1);
		quickSort(A, j+1, hi);
	}
	
	public static int partition(int []A, int lo, int hi){
		int v = A[lo];
		int i = lo, j = hi+1;
		while(true){
			while(A[++i] < v){
				if(i == hi)	break;
			}
			while(v < A[--j]){
				if(j == lo)	break;
			}
			if(i >= j)	break;
			exchg(A, i, j);
		}
		exchg(A, lo, j);
		return j;
	}
	
	private static void exchg(int[] A, int m, int n){
		int temp = A[m];
		A[m] = A[n];
		A[n] = temp;
	}
	// 三项切分
	public static void quickSort3Way(int[] A){
		quickSort3Way(A, 0, A.length-1);
	}
	
	private static void quickSort3Way(int[] A, int lo, int hi){
		if(hi <= lo)	return;
		int lt = lo, i = lo + 1, gt = hi;
		int val = A[lo];
		while(i <= gt){
			if(A[i] < val){
				exchg(A, lt++, i++);
			}else if(A[i] > val){
				exchg(A, i, gt--);
			}else{
				i++;
			}
		}
		quickSort3Way(A, lo, lt-1);
		quickSort3Way(A, gt+1, hi);
	}
}
