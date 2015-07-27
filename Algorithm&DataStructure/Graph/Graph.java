import java.util.LinkedList;
import java.util.List;

public class Graph {
	private final int V;
	private int E;
	private LinkedList<Integer>[] adj; //邻接表(adjacent list)
	public Graph(int V){
		this.V = V;
		this.E = 0;
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	public int V(){	return V;	}
	public int E(){	return E;	}
	public void addEdge(int v, int w){
		adj[v].addFirst(w);
		adj[w].addFirst(v);
		E++;
	}
	public LinkedList<Integer> adj(int v){
		return adj[v];
	}
}
