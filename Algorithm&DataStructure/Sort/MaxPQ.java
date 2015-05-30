
public class MaxPQ {
	public int[] pq;
	private static int N = 0;
	public MaxPQ(int maxN){
		pq = new int[maxN+1];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	public int get(int i){
		if(i > N){
			System.out.println("out of Bound");
		}
		return pq[i];
	}
	public void insert(int val){
		pq[++N] = val;
		swim(N);
	}
	
	public int delMax(){
		int max = pq[1];  // get the 2nd element in the queue
		swap(1, N--);     // swap the 2nd with the last and shrink the queue size
		pq[N+1] = 0;      // set the last one is 0
		sink(1);          // recover the heap by sink method
		return max;
	}
	
	private void swap(int m, int n){
		int temp = pq[m];
		pq[m] = pq[n];
		pq[n] = temp;
	}
	
	private void swim(int n){
		while(n > 1 && pq[n] > pq[n/2]){
			swap(n, n/2);
			n = n / 2;
		}
	}
	
	private void sink(int root){
		while(2*root <= N){
			int j = 2 * root;
			if(j < N && pq[j] < pq[j+1])
				j++;
			if(pq[root] >= pq[j])	
				break;
			swap(root, j);
			root = j;
		}
	}
	
	private static void printPQ(MaxPQ pq){
		for(int i = 0; i <= pq.size(); i++){
			System.out.print(pq.get(i)+" ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		MaxPQ pq = new MaxPQ(10);
		pq.insert(1);
		pq.insert(20);
		pq.insert(15);
		pq.insert(53);
		pq.insert(25);
		
		printPQ(pq);
		pq.delMax();
		printPQ(pq);

	}
}
