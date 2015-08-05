// @breif: ShortestPathDijkstra Class
//         Dijkstra algorithm to find the shortest path
// @reference: Princeton Algorithm book P.423

import java.util.LinkedList;

// O(V) space, O(ElogV) time
public class ShortestPathDijkstra {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	//private boolean[] visited;
	private IndexMinPQ<Double> pq;
	private int source;
	EdgeWeightedDigraph G;
	
	// @brief ShortestPathDijkstra Constructor
	// @status finished
	public ShortestPathDijkstra(EdgeWeightedDigraph G, int s){
		source = s;
		this.G = G;
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());

		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		
		pq.insert(s, 0.0);
		while(!pq.isEmpty()){
			relax(G, pq.delMin());
		}
	}
	
	// @brief Edge relaxation helper function of ShortestPathDijkstra() 
	// @status finished
	@SuppressWarnings("deprecation")
	private void relax(EdgeWeightedDigraph G, int v){
		for(DirectedEdge e : G.adj(v)){
			int w = e.to();
			if(distTo[w] > distTo[v] + e.weight()){
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if(pq.contains(w))
					pq.change(w, distTo(w));
				else {
					pq.insert(w, distTo(w));
				}
			}
		}
	}
	
// O(V) method to get the next node which is worse than IndexMinPQ
//	private int minVertex(EdgeWeightedDigraph G) {
//		 int y = -1;   // graph not connected, or no unvisited vertices
//		 for (int i = 0; i < G.V(); i++) {
//			 if (!visited[i] && distTo[i] < Double.POSITIVE_INFINITY) {
//				 y = i; 
//			 }
//		 }
//		 return y;
//	}
	
	// @brief Return the weight of shortest path from source to v
	// @status finished
	public double distTo(int v){
		if(v >= G.V()){
	        System.out.println("Error: Invalid input");
	        return 0.0;
		}
		return distTo[v];
	}
	
	// @brief Check if there is shortest path from source to v 
	// @status finished
	public boolean hasPathTo(int v){
		if(v >= G.V()){
	        System.out.println("Error: Invalid input");
	        return false;
		}
		return distTo[v] != Double.POSITIVE_INFINITY;
	}
	
	// @brief Print and return the shortest path from source to v 
	// @status finished
	public LinkedList<DirectedEdge> getPath(int v){
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
