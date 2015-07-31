// @breif: Directed Graph Class
//         This is Directed Graph Class
// @reference: Princeton Algorithm book P.364

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class Digraph {
	private int V;
	private int E;
	private LinkedList<Integer>[] adj;

	// @brief Digraph Constructor without input file
	// @status finished
	public Digraph(int v){
		V = v;
		E = 0;
		adj = new LinkedList[this.V];
		for(int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	// @brief Digraph Constructor which can load and build graph from .txt file
	// @status finished
	public Digraph(String in) throws IOException{
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
	        			adj[i] = new LinkedList<Integer>();
	        	}else if(cnt == 2) {
	        		this.E = Integer.parseInt(line);
	        		System.out.println("Graph has "+ this.V + " vertices and "+this.E+" edges");
	        	}else{
	        		String[] tokens = line.split(" ");
		        	int v = Integer.parseInt(tokens[0]); 
		        	int w = Integer.parseInt(tokens[1]);
		        	System.out.println("add edge from v: "+ v +  " to w: " + w);
		        	addEdge(v, w);
	        	}
			}
		}finally{
			if(br != null) br.close();
		}
	}
	
	// @brief Print adjacent list of Digraph
	// @status finished
	public void printAdjList(){
		System.out.println("Adjacent List:");
		for(int i = 0; i < this.V; i++){
			System.out.print(i + " -> ");
			for(int j : this.adj[i]){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// @brief Return the number of vertices in the Digraph
	// @status finished
	public int V(){	 return V;	}
	
	// @brief Return the number of edges in the Digraph
	// @status finished
	public int E(){	 return E;	}
	
	// @brief Add an edge from node v to node w
	// @status finished
	public void addEdge(int v, int w){
		adj[v].addFirst(w);
		E++;
	}
	
	// @brief Create a new Digraph wich has the opposite direction with the 
	//        original one
	// @status finished
	public Digraph reverse(){
		Digraph R = new Digraph(this.V);
		for(int i = 0; i < this.V; i++){
			for(int j : this.adj[i])
				addEdge(j, i);
		}
		return R;
	}
}
