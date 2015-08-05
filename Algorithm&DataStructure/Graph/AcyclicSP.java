// @breif: AcyclicSP Class
//         Algorithm to find the shortest path in Acyclic DiGraph
// @reference: Princeton Algorithm book P.427

// 注: AcyclicSP主要应用于加权无环有向图的最短路径, 权值可以是负数, 其效率比Dijkstra高, 为线性时间

import java.util.LinkedList;

public class AcyclicSP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private int source;
	
	public AcyclicSP(EdgeWeightedDigraph G, int s){
		this.source = s;
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		Topological topl = new Topological(G);
		for(int v : topl.order()){
			for (DirectedEdge e : G.adj(v))
				relax(e);
		}
	}
	
	 // relax edge e
    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }       
    }
    
    // @brief Return the weight of shortest path from source to v
 	// @status finished
    public double distTo(int v) {
        return distTo[v];
    }
    
    // @brief Check if there is shortest path from source to v 
    // @status finished
    public boolean hasPathTo(int v) {
        return distTo[v] != Double.POSITIVE_INFINITY;
    }
    
    // @brief Print and return the shortest path from source to v 
 	// @status finished
    public LinkedList<DirectedEdge> getPath(int v) {
        LinkedList<DirectedEdge> path = new LinkedList<DirectedEdge>();
		if (!hasPathTo(v)) return path;

        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.addFirst(e);
        }

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
}
