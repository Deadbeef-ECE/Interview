public class MergeSortTopDown {
	public static int[] aux;
	// O(n) Space 仅仅是merge, merge 俩ordered small arrays
	public static void Merge(int[] a, int lo, int mid, int hi){
		int i = lo, j = mid + 1;
		// copy a[] to aux[]
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		
		for(int k = lo; k <= hi; k++){
			// bound detection
			if(i > mid)     // i[0, mid], i越界
				a[k] = aux[j++];
			else if(j > hi) // j[mid+1, hi]， j越界
				a[k] = aux[i++];
			// normal case: put the smaller one into the a[]'s next position
			else if(aux[j] < aux[i])
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	public static void sort(int[] a){
		aux = new int[a.length];
		// pass index
		sort(a, 0, a.length-1);
	}
	// Top-down merger-sort
	public static void sort(int[] a, int lo, int hi){
		if(hi <= lo)	return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		if(a[mid] < a[mid+1])
			return;
		Merge(a, lo, mid, hi);
	}
}

