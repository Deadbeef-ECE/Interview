// CC = Connected Component 即连通分量

public class CC {
	private Graph G;
	private boolean[] marked;
	private int count;
	private int[] id;
	
	// @brief Constructor of CC with Graph G as input
	// @status finished
	public CC(Graph G){
		this.G = G;
		count = 0;
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int s = 0; s < G.V(); s++){
			if(!marked[s]){
				dfs(G, s);
				count++;
			}
		}
	}
	
	// @brief DFS helper function used for mark different Connected Component
	// @status finished
	private void dfs(Graph G, int v){
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G, w);
		}
	}
	
	// @brief Check if v and w is connected(in the same component)
	// @status finished
	public boolean isConnected(int v, int w){
		if(v > G.V() || w > G.V()){
			System.out.println("Error: Invalid input!\n");
			return false;
		}
		if(id[v] == id[w]){
			System.out.println(v + " and "+ w +" is connected");
			System.out.println("Connected Component ID: " + id[v] + "\n");
		}else{
			System.out.println(v + " and "+ w +" is not connected!");
			System.out.println("id["+ v +"]: " + id[v] + ", id["+ w +"]: " + id[w] + "\n");
		}
		return id[v] == id[w];
	}
	
	// @brief Return the number of different connected component
	// @status finished
	public int count(){  
		System.out.println("This graph has " + count + " different Connected Components\n");
		return count;  
	}
	
	// @brief Return the component id with give node
	// @status finished
	public int id(int v){
		if(v > G.V()){
			System.out.println("Error: Invalid input!\n");
			return -1;
		}
		System.out.println("node " + v + "'s CC id: " + id[v]);
		return id[v];
	}
}
