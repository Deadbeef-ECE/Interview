package UnionFind;

/********************************************************
 * Quick Union[Lazy Approach]
 * 
 * Defect: 
 * 	• Trees can get tall
 *	• Find too expensive (could be N steps)
 *	• Need to do find to do union
 *  
 * Time complexity: 
 * Union O(N)
 * Find O(N) 
 * 
 *******************************************************/
public class QuickUnionUF {
	private int[] id;
	private int count;
	
	public QuickUnionUF(int N){
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
		while(p != id[p])
			p = id[p];
		return p;
	}
	
	/* Return number of connected components*/
	public int count(){
		return count;
	}
}
