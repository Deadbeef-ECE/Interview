package UnionFind;

/********************************************************
 * Weighted Quick Union
 *  
 * Time complexity: 
 * Union O(logN)
 * Find O(logN) 
 * 
 *******************************************************/
public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	private int count;
	
	public WeightedQuickUnionUF(int N){
		count = N;
		for(int i = 0; i < N; i++){
			id[i] = i;
			sz[i] = 1;
		}
	}
	
    /* Merge components containing p and q */
	public void union(int p, int q){
		int i = find(p), j = find(q);
		if(i == j)	return;
		
        // make smaller root point to larger one
		if( sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
		else               { id[j] = i; sz[i] += sz[j]; }
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
