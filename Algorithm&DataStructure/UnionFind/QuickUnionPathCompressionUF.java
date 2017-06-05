package UnionFind;

public class QuickUnionPathCompressionUF {
	private int[] id;
	private int count;
	
	public QuickUnionPathCompressionUF(int N){
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++)
			id[i]= i;
	}
	
    /* Merge components containing p and q */
	public void union(int p, int q){
		int rootP = find(p), rootQ = find(q);
		if(rootP == rootQ)	return;
		id[rootP] = rootQ;
		count--;
	}
	
	/* Check if p q is connected */
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
    /* Return root of component corresponding to element p */
	public int find(int p){
		int root = p;
		while (root != id[root])
			root = id[root];
		while (p != root) {
			int newp = id[p];
			id[p] = root;
			p = newp;
		}
		return root;
	}
	
	/* Return number of connected components*/
	public int count(){
		return count;
	}
}
