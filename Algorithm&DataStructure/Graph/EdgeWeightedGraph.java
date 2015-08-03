// @breif: EdgeWeightedGraph Class
//         Mainly used for minimum spanning tree
// @reference: Princeton Algorithm book P.395

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class EdgeWeightedGraph {
	private int V;
	private int E;
	private LinkedList<Edge>[] adj;
	
	// @brief EdgeWeightedGraph Constructor without input file
	// @status finished
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V){
		this.V = V;
		this.E = 0;
		adj = new LinkedList[this.V];
		for(int v = 0; v < V; v++){
			adj[v] = new LinkedList<Edge>();
		}
	}
	
	// @brief EdgeWeightedGraph Constructor with input file
	// @status finished
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(String in) throws IOException{
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(in));
			String line;
			int cnt = 0;
			while((line = br.readLine()) != null){
				cnt++;
				if(cnt == 1){
					this.V = Integer.parseInt(line);
	        		adj = new LinkedList[this.V];
	        		for(int i = 0; i < V; i++)
	        			adj[i] = new LinkedList<Edge>();
				}else if(cnt == 2){
					this.E = Integer.parseInt(line);
	        		System.out.println("Graph has "+ this.V + " vertices and "+this.E+" edges");
				}else{
					line = line.trim();
	        		String[] tokens = line.split(" ");
		        	int v = Integer.parseInt(tokens[0]); 
		        	int w = Integer.parseInt(tokens[1]);
		        	double weight = Double.parseDouble(tokens[2]);
		        	Edge e = new Edge(v, w, weight);
		        	System.out.println("add edge between v: "+ v +  " to w: " + w + " weight: "+ weight);
		        	addEdge(e);
				}
			}
		}finally{
			if(br != null) br.close();
		}
	}
	
	// @brief Add an edge between node v to node w
	// @status finished
	public void addEdge(Edge e){
		int v = e.either(); 
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	
	// @brief Print adjacent list of Digraph
	// @status finished
	public void printAdjList(){
		System.out.println("Adjacent List:");
		for(int i = 0; i < this.V; i++){
			System.out.print(i + " -> ");
			for(Edge e : this.adj[i]){
				System.out.print(e.other(i) + "(weight: " + e.weight() + ")  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// @brief Return neighbors with given node in EdgeWeightedGraph
	// @status finished
	public LinkedList<Edge> adj(int v) {	return adj[v];	}
	
	// @brief Return the number of vertices in the EdgeWeightedGraph
	// @status finished
	public int V() {	return V;	}
	
	// @brief Return the number of edges in the EdgeWeightedGraph
	// @status finished
	public int E() {	return E;	}
	
}
