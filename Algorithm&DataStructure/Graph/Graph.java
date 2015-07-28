import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Graph {
	private int V;
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
	// load and build graph from file
	public Graph(String in) throws IOException{
	    BufferedReader br = null; 
	    try { 
	        br = new BufferedReader(new FileReader(in)); 
	        String line;
	        int cnt = 0;
	        while ((line = br.readLine()) != null) { 
	        	//System.out.println(line);
	        	cnt++;
	        	if(cnt == 1){
	        		this.V = Integer.parseInt(line);
	        		adj = new LinkedList[this.V];
	        		for(int i = 0; i < V; i++){
	        			adj[i] = new LinkedList<Integer>();
	        		}
	        	}else if(cnt == 2) {
	        		this.E = Integer.parseInt(line);
	        		System.out.println("Graph has "+ this.V + " vertices and "+this.E+" edges");
	        	}else{
	        		String[] tokens = line.split(" ");
		        	int v = Integer.parseInt(tokens[0]); 
		        	int w = Integer.parseInt(tokens[1]);
		        	System.out.println("add edge between v: "+ v +  " w: " + w);
		        	addEdge(v, w);
	        	}
	        } 
	    } finally { 
	    	if (br != null) br.close(); // dont throw an NPE because the file wasn't found.
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
	
	// return the connected node with s
	public LinkedList<Integer> search(int s){
		LinkedList<Integer> ret = new LinkedList<Integer>();
		boolean[] marked = new boolean[this.V];
		int[] cnt = {0};
		
		dfs(s, marked, cnt);
		for(int i = 0; i < this.V; i++){
			if(marked[i])
				ret.add(i);
		}
		
		for(int i : ret)
			System.out.print(i+" ");
		System.out.println();
		
		if(cnt[0] != this.V)
			System.out.print("This Graph is NOT connected");
		return ret;
	}
	private void dfs(int s, boolean[] marked, int[] cnt){
		marked[s] = true;
		cnt[0]++;
		for(int w : this.adj[s]){
			if(!marked[w])
				dfs(w, marked, cnt);
		}
	}
	// Print path from s to v
	
	public LinkedList<Integer> HasPath(int s, int v){
		LinkedList<Integer> ret = new LinkedList<Integer>();
		boolean[] marked = new boolean[this.V];
		int[] edgeTo = new int[this.V];
		dfsPath(v, marked, edgeTo);
		if(marked[v]){
			
		}
		return ret;
	}
	private void dfsPath(int v, boolean[] marked, int[] edgeTo){
		marked[v] = true;
		for(int w : this.adj[v]){
			if(!marked[w]){
				edgeTo[w] = v;
				dfsPath(w, marked, edgeTo);
			}
		}
	}
	
}
