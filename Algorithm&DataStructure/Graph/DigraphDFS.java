// @breif: DigraphDFS Class
//         To print all connected nodes with given one use DFS search
// @reference: Princeton Algorithm book P.368

import java.util.LinkedList;

public class DigraphDFS {
	private Digraph G;
	
	// @brief DigraphDFS Constructor
	// @status finished
	public DigraphDFS(Digraph G){
		this.G = G;
	}
	
	// @brief Return the (direct && indirect) connected node with s
	// @status finished
	public LinkedList<Integer> search(int s){
		LinkedList<Integer> ret = new LinkedList<Integer>();
		boolean[] marked = new boolean[G.V()];
		int[] cnt = {0};
		
		if(s > G.V()){
			System.out.println("Error: Invalid input! ");
			return ret;
		}
		dfs(s, marked, cnt);
		for(int i = 0; i < G.V(); i++){
			if(marked[i])
				ret.add(i);
		}
		
		System.out.println("These node can reach from " + s);
		for(int i : ret)
			System.out.print(i+" ");
		System.out.println();
		if(cnt[0] != G.V())
			System.out.println("Not all nodes in digraph can reach from " + s + "\n");
		else
			System.out.println("All nodes in digraph can reach from " + s + "\n");
		return ret;
	}
	
	// @brief DFS helper function of search()
	// @status finished
	private void dfs(int s, boolean[] marked, int[] cnt){
		marked[s] = true;
		cnt[0]++;
		for(int v : G.adj(s)){
			if(!marked[v])
				dfs(v, marked, cnt);
		}
	}
}
