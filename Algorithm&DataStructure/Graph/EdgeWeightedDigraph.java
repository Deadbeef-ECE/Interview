// @breif: EdgeWeightedDigraph Class
//         Mainly used for shortest path problems
// @reference: Princeton Algorithm book P.415

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.LinkedList;

public class EdgeWeightedDigraph {
	private int V;
	private int E;
	private LinkedList<DirectedEdge>[] adj;
	
	// @brief EdgeWeightedDigraph Constructor without input file
	// @status finished
	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(int V){
		this.V = V;
		this.E = 0;
		adj = new LinkedList[this.V];
		for(int v = 0; v < this.V; v++)
			adj[v] = new LinkedList<DirectedEdge>();
	}
	
	// @brief EdgeWeightedDigraph Constructor with input file
	// @status finished
	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(String in) throws IOException{
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
	        			adj[i] = new LinkedList<DirectedEdge>();
				}else if(cnt == 2){
					this.E = Integer.parseInt(line);
	        		System.out.println("Graph has "+this.V+" vertices and "+this.E+" edges");
				}else{
					line = line.trim();
	        		String[] tokens = line.split(" ");
		        	int v = Integer.parseInt(tokens[0]); 
		        	int w = Integer.parseInt(tokens[1]);
		        	double weight = Double.parseDouble(tokens[2]);
		        	DirectedEdge e = new DirectedEdge(v, w, weight);
		        	//System.out.println("add edge from v: "+ v +  " to w: " + w + " weight: "+ weight);
		        	addEdge(e);	
				}
			}
		}finally{
			if(br != null) br.close();
		}
	}
	
	// @brief Add a DirectedEdge e
	// @status finished
	public void addEdge(DirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}
	
	// @brief Print adjacent list of EdgeWeightedDigraph
	// @status finished
	public void printAdjList(){
		System.out.println("Adjacent List:");
		for(int i = 0; i < this.V; i++){
			System.out.print(i + " -> ");
			for(DirectedEdge e : this.adj[i]){
				System.out.print(e.to() + "(weight: " + e.weight() + ")  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// @brief Return neighbors with given node in EdgeWeightedDigraph
	// @status finished
	public LinkedList<DirectedEdge> adj(int v) {	return adj[v];	}
	
	// @brief Return the number of vertices in the EdgeWeightedDigraph
	// @status finished
	public int V() {	return V;	}
	
	// @brief Return the number of edges in the EdgeWeightedDigraph
	// @status finished
	public int E() {	return E;	}
	
	// @brief Return edges of the DirectedEdge
	// @status finished
	public LinkedList<DirectedEdge> edges(){
		LinkedList<DirectedEdge> list = new LinkedList<DirectedEdge>();
		for(int v = 0; v < V; v++){
			for(DirectedEdge e : adj[v])
				list.add(e);
		}
		return list;
	}
}
