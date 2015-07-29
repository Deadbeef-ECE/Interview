// @breif: Graph Class
//         This is Undirected Graph Class
// @reference: Princeton Algorithm book P.349

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private int V;
	private int E;
	private LinkedList<Integer>[] adj; //邻接表(adjacent list)

	// @brief Graph Constructor without input file
	// @status finished
	public Graph(int V){
		this.V = V;
		this.E = 0;
		adj = new LinkedList[V];
		for(int i = 0; i < V; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	// @brief Graph Constructor which can load and build graph from .txt file
	// @status finished
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
//		        	System.out.println("add edge between v: "+ v +  " w: " + w);
		        	addEdge(v, w);
	        	}
	        } 
	    } finally { 
	    	if (br != null) br.close(); // dont throw an NPE because the file wasn't found.
	    }
	}
	
	// @brief Print adjacent list of graph
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
	
	// @brief Return the number of vertices in the graph
	// @status finished
	public int V(){	 return V;	}
	
	// @brief Return the number of edges in the graph
	// @status finished
	public int E(){	 return E;	}
	
	// @brief Add an edge between node v and w
	// @status finished
	public void addEdge(int v, int w){
		adj[v].addFirst(w);
		adj[w].addFirst(v);
		E++;
	}
	
	// @brief Return all the neighbors of give node v
	// @status finished
	public LinkedList<Integer> adj(int v){	return adj[v];	}
	
	// @brief Return the (direct && indirect) connected node with s
	// @status finished
	public LinkedList<Integer> search(int s){
		LinkedList<Integer> ret = new LinkedList<Integer>();
		boolean[] marked = new boolean[this.V];
		int[] cnt = {0};
		
		dfs(s, marked, cnt);
		for(int i = 0; i < this.V; i++){
			if(marked[i])
				ret.add(i);
		}
		System.out.println("These node can reach from " + s);

		for(int i : ret)
			System.out.print(i+" ");
		System.out.println();
		
		if(cnt[0] != this.V)
			System.out.println("This Graph is NOT connected\n");
		return ret;
	}
	
	// @brief Helper function of search()
	// @status finished
	private void dfs(int s, boolean[] marked, int[] cnt){
		marked[s] = true;
		cnt[0]++;
		for(int w : this.adj[s]){
			if(!marked[w])
				dfs(w, marked, cnt);
		}
	}
	
	// @brief Print path from s to v with DFS recursion
	// @status finished
	public LinkedList<Integer> HasPathDFS(int s, int v){
		LinkedList<Integer> ret = new LinkedList<Integer>();
		LinkedList<Integer> path = new LinkedList<Integer>();
		boolean[] marked = new boolean[this.V];
		marked[s] = true;
		dfsPath(s, v, marked, path, ret);
		if(marked[v] == false){
			System.out.println("Can not find path from " + s + " to " + v + "!\n");
			return ret;
		}
		printPath(s, v, ret);
		return ret;
	}
	
	// @brief Helper function for hasPathDFS()
	// @status finished
	private void dfsPath(int s, int v, boolean[] marked, LinkedList<Integer> path, LinkedList<Integer> ret){
		if(s == v){
			ret.addAll(path);
			return;
		}
		for(int w : this.adj[s]){
			if(marked[w] == false){
				marked[w] = true;
				path.add(w);
				dfsPath(w, v, marked, path, ret);
			}
		}
	}
	
	// @brief Print path from s to v with BFS iteration
	// @status finished
	public LinkedList<Integer> HasPathBFS(int s, int v){
		LinkedList<Integer> ret = new LinkedList<Integer>();
		int[] edgeTo = new int[this.V];
		boolean[] marked = new boolean[this.V];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		marked[s] = true;
		while(!queue.isEmpty()){
			int node = queue.poll();
			LinkedList<Integer> neighbors = this.adj[node];
			for(int n : neighbors){
				if(!marked[n]){
					edgeTo[node] = n;
					marked[n] = true;
					queue.add(n);
				}
			}
		}	
		if(marked[v] == false){
			System.out.println("Can not find a path from "+ s +" to " + v + "!\n");
			return ret;
		}
		for(int n = v; n != s; n = edgeTo[n])
			ret.addFirst(n);
		printPath(s, v, ret);
		return ret;
	}
	
	// @brief Helper function used for print path from s to v
	// @status finished
	private static void printPath(int s, int v, LinkedList<Integer> ret){
		System.out.print("Find path from " + s + " to " + v +"\n"+s +"->");
		for(int i = 0 ; i < ret.size(); i++){
			System.out.print(ret.get(i));
			if(i != ret.size() - 1){
				System.out.print("->");
			}
		}
		System.out.println("\n");
	}
}
