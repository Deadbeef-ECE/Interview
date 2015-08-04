// @breif: Real-time Prim MST Algorithm
// @reference: Princeton Algorithm book P.403

import java.util.LinkedList;
import java.util.Queue;

// O(V) space, O(ElogV) time
public class PrimMST {
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;
	
	// @brief PrimMST Constructor
	// @status finished
	public PrimMST(EdgeWeightedGraph G){
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());
		distTo[0] = 0.0;
		pq.insert(0, 0.0);
		while(!pq.isEmpty()){
			visit(G, pq.delMin());
		}
	}
	
	// @brief Helper function of PrimMST Constructor
	// @status finished
	@SuppressWarnings("deprecation")
	private void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		for(Edge e : G.adj(v)){
			int w = e.other(v);
			if(marked[w])	continue;
			if(e.weight() < distTo[w]){
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if(pq.contains(w))
					pq.change(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
			}
		}
	}
	
	// @brief Print and return all edges in MST
	// @status finished
	public Queue<Edge> edges(boolean print){
		if(print == true)
			System.out.println("Edges of PrimMST:");
		Queue<Edge> mst = new LinkedList<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
            	if(print == true){
            		int s = e.either();
        			int w = e.other(s);
        			double weight = e.weight();
        			System.out.println(s + " -> " + w + " (weight: " + weight +")");
            	}
                mst.add(e);
            }
        }
		return mst;	
	}
	
	// @brief Print and return total weight in MST
	// @status finished
	public double weight(){
		double ret = 0.0;
		for(Edge e : edges(false))
			ret += e.weight();
		System.out.println("\nTotal weight of MST: " + ret);
		return ret;
	}
}
