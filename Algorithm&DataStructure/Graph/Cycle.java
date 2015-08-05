// @breif: Cycle Class
//         Check if graph has cycle or not
// @reference: Princeton Algorithm book P.352

public class Cycle {
	private boolean hasCycle;
	private boolean[] marked;
	
	// @brief Constructor of Cycle class with Graph G as input
	// @status finished
	public Cycle(Graph G){
		marked = new boolean[G.V()];
		hasCycle = false;
		for(int s = 0; s < G.V(); s++){
			if(!marked[s])
				dfs(G, s, s);
		}
	}
	
	// @brief DFS helper function used for cycle detection
	// @status finished
	private void dfs(Graph G, int v, int u){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				dfs(G, w, v);
			}else if(w != u){
				hasCycle = true;
			}
		}
	}
	
	// @brief Return the result of cycle detection
	// @status finished
	public boolean hasCycle(){
		if(hasCycle)
			System.out.println("This graph contains cycle");
		else
			System.out.println("This graph does not have cycle");	
		return hasCycle;
	}
}
