
public class HeapSort {
	public static void sort(int[] a){
		int N = a.length-1;
		for(int k = N/2; k >= 1; k--)
			sink(a, k, N);
		while(N > 1){
			swap(a, 1, N--);
			sink(a, 1, N);
		}
	}
	
	private static void sink(int[] pq, int root, int N){
		while(2*root <= N){
			int j = 2 * root;
			// 如果j没越界，找大的孩子
			if(j < N && pq[j] < pq[j+1])
				j++;
			// 如果pq[root]大于较大的孩子，跳出循环，说heap已经建好
			if(pq[root] >= pq[j])
				break;
			// 否则root交换和大孩子交换
			swap(pq, root, j);
			root = j;
		}
	}
	
	private static void swap(int[] pq,int m, int n){
		int temp = pq[m];
		pq[m] = pq[n];
		pq[n] = temp;
	}
}
