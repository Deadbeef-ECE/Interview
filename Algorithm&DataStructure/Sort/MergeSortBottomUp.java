public class MergeSortBottomUp {
	public static int[] aux;
	public static void Merge(int[] a, int lo, int mid, int hi){ 
		int i = lo;
		int j = mid + 1;
		// copy a[] to aux[]
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		
		for(int k = lo; k <= hi; k++){
			// bound detection
			if(i > mid)     // i[0, mid], i 越界
				a[k] = aux[j++];
			else if(j > hi) // j[mid+1, high], j 越界
				a[k] = aux[i++];
			// normal case: put the smaller one into the a[]'s next position
			else if(aux[j] < aux[i])
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	public static void sort(int[] a){
		int len = a.length;
		aux = new int[len];
		for(int sz = 1; sz < len; sz = sz+sz){
			for(int lo = 0; lo < len-sz; lo += sz+sz){
				Merge(a, lo, lo+sz-1, Math.min(lo+2*sz-1, len-1));
			}
		}
	}
}
