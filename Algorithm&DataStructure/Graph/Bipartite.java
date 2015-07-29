// @breif: Bipartite Class
//         Check if graph is Bipartite or not (二分图)
// @reference: Princeton Algorithm book P.352

public class Bipartite {
	private Graph G;
	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColorable = true;
	
	// @brief Constructor of Bipartite class with Graph G as input
	// @status finished
	public Bipartite(Graph G){
		this.G = G;
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		for(int s = 0; s < G.V(); s++){
			if(!marked[s])
				dfs(G, s);
		}
	}
	
	// @brief DFS helper function used for Bipartite
	// @status finished
	private void dfs(Graph G, int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w]){
				color[w] = !color[v];
				dfs(G, w);
			}else if(color[w] == color[v]){
				isTwoColorable = false;
			}
		}
	}
	
	// @brief Chack if the graph is Bipartite or not
	// @status finished
	public boolean isBipartite(){
		if(isTwoColorable)
			System.out.println("This graph is Bipartite");
		else
			System.out.println("This graph is not Bipartite");
		return isTwoColorable;
	}
}
