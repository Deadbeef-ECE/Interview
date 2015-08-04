// @breif: Kruskal MST Algorithm
// @reference: Princeton Algorithm book P.406

import java.util.LinkedList;
import java.util.PriorityQueue;

public class KruskalMST {
	private LinkedList<Edge> mst;

	// @brief KruskalMST Constructor
	// @status finished
	public KruskalMST(EdgeWeightedGraph G){
		mst = new LinkedList<Edge>();
		PriorityQueue<Edge> pq= new PriorityQueue<Edge>();
		UF uf = new UF(G.V());
		for(Edge e: G.edges())
			pq.add(e);
		while(!pq.isEmpty() && mst.size() < G.V() - 1){
			Edge e = pq.poll();
			int v = e.either(); int w = e.other(v);
			if(uf.connected(v, w))	continue;
			uf.union(v, w);
			mst.add(e);
		}
	}
	
	// @brief Print and return all edges in MST
	// @status finished
	public LinkedList<Edge> edges(){
		System.out.println("Edges of KruskalMST:");
        for (Edge e : mst) {
    		int v = e.either();
			int w = e.other(v);
			double weight = e.weight();
			System.out.println(v + " -> " + w + " (weight: " + weight +")");
    	}
		return mst;
	}

	// @brief Print and return total weight in KruskalMST
	// @status finished
	public double weight(){
		double ret = 0.0;
		for(Edge e : mst)
			ret += e.weight();
		System.out.println("\nTotal weight of KruskalMST: " + ret);
		return ret;
	}
}
