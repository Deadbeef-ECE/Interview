package UnionFind;

/********************************************************
 * Quick Find[Eager Approach]
 * 
 * Defect:
 * 	• Union too expensive (N steps).
 * 	• Trees are flat, but too expensive to keep them flat
 * 
 * Time complexity: 
 * Union O(N)
 * Find O(1); 
 * 
 ********************************************************/

public class QuickFindUF {
	private int[] id;
	private int count;
	
	/* Initialize the QuickFindUF with given size N */
	public QuickFindUF(int N){
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++)
			id[i] = i;
	}
	
	/* Union p and q */
	public void union(int p, int q){
		if(connected(p, q))	return;
		int pid = id[p];
		for(int i = 0; i < id.length; i++)
			if(id[i] == pid)  id[i] = id[q];
		count--;
	}
	
	/* Check if p q is connected */
	public boolean connected(int p, int q){
		return id[p] == id[q];  
	}
	
    /* Return root of component corresponding to element p */
	public int find(int p){
		return id[p];
	}
	
	/* return number of connected components*/
    public int count() {
        return count;
    }
}
