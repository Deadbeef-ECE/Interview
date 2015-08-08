// @breif: ShortestPathDijkstra Class
//         Dijkstra algorithm to find the shortest path
// @reference: Princeton Algorithm book P.423

// 注: 在relax V轮之后, 如果queue非空, 说明该有向图中存在一个从起点可达的负权重环
//     因为如果不存在从起点可达的负权重环的话, relax V-1轮后, 算法会结束
//     如果不结束, 说明edgeTo[]中含有一个环且该环必然为负数, 因为w会在路径上出现两次,
//     且第二次s->w的路径长度小于第一次s->w的路径长度

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// O(v) space, O(EV) time
public class ShortestPath_BellmanFord {
	private double[] distTo;
	private DirectedEdge[] edgeTo;
	private Queue<Integer> queue;
	private int cost;
	private Stack<DirectedEdge> cycle;
	private int source;
	private EdgeWeightedDigraph G;
	
	// @brief ShortestPath_BellmanFord Constructor
	// @status finished
	public ShortestPath_BellmanFord(EdgeWeightedDigraph G, int s){
		this.G = G;
		this.source = s;
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		queue = new LinkedList<Integer>();
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		queue.add(s);
		while(!queue.isEmpty() && !hasNegativeCycle()){
			int v = queue.poll();
			relax(G, v);
		}
	}

	// @brief Edge relaxation helper function of ShortestPath_BellmanFord() 
	// @status finished
	private void relax(EdgeWeightedDigraph G, int v){
		for(DirectedEdge e : G.adj(v)){
			int w = e.to();
			if(distTo[w] > distTo[v] + e.weight()){
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(!queue.contains(w))
					queue.add(w);
			}
			if(cost++ % G.V() == 0){
				findNegativeCycle();
			}
		}
	}
	
	// @brief Return the weight of shortest path from s to v
	// @status finished
	public double distTo(int v){
		return distTo[v];
	}
	
	// @brief Check if there is shortest path from s to v 
	// @status finished
	public boolean hasPathTo(int v){
		if(v >= G.V()){
			System.out.println("Error: input node not exist!");
			return false;
		}
		if(distTo[v] == Double.POSITIVE_INFINITY)
			System.out.println("Cannot reach to " + v);
		return distTo[v] != Double.POSITIVE_INFINITY;
	}
	
	// @brief Print and return the shortest path from source to v 
	// @status finished
	public Iterable<DirectedEdge> getPathTo(int v) {
        if (hasNegativeCycle()){
	        System.out.println("This graph DOES have cycle"); 
        	return null;
        }
        LinkedList<DirectedEdge> path = new LinkedList<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.addFirst(e);
        
        System.out.println("Path: " + source + " to " + v);
        for(DirectedEdge e : path){
        	int m = e.from();
        	int n = e.to();
        	double weight = e.weight();
        	System.out.print(m + "->" + n + "(weight: " + weight + ") " );
        }
        System.out.format("\ntotalWeight %.2f\n\n", distTo[v]); 
        
        return path;
    }
	
	// @brief Find if there is a cycle in added paths(if find cycle, it must be nagative one)
	// @status finished
	public void findNegativeCycle(){
		int V = edgeTo.length;
		EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
		for(int v = 0; v < V; v++){
			if(edgeTo[v] != null)
				spt.addEdge(edgeTo[v]);
		}
		//spt.printAdjList();
		EdgeWeightedDirectedCycle cf = new EdgeWeightedDirectedCycle(spt);
		cycle = cf.cycle();
	}
	
	// @brief Check if there is a cycle in added paths(if find cycle, it must be nagative one)
	// @status finished
	public boolean hasNegativeCycle(){	return cycle != null;	}
	
	// @brief Return the cycle in added paths(if find cycle, it must be nagative one)
	// @status finished
	public Iterable<DirectedEdge> negativeCycle(){
		if(!hasNegativeCycle()){
	        System.out.println("This graph does NOT has cycle"); 
			return null;
		}
		return cycle;
	}
}
