// @breif: Lazy Prim MST Algorithm
// @reference: Princeton Algorithm book P.400

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimMSTLazy {
	private boolean[] marked;
	private LinkedList<Edge> mst;
	private PriorityQueue<Edge> pq;
	
	// @brief PrimMSTLazy Constructor
	// @status finished
	public PrimMSTLazy(EdgeWeightedGraph G){
		pq = new PriorityQueue<Edge>();
		marked = new boolean[G.V()];
		mst = new LinkedList<Edge>();
		visit(G, 0);
		while(!pq.isEmpty()){
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if(marked[v] && marked[w])	continue;
			mst.add(e);
			if(!marked[v])	visit(G, v);
			if(!marked[w])	visit(G, w);
		}
	}
	
	// @brief Helper function of PrimMSTLazy Constructor
	// @status finished
	private void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		for(Edge e: G.adj(v)){
			if(!marked[e.other(v)])
				pq.add(e);
		}
	}
	
	// @brief Print and return all edges in MST
	// @status finished
	public Queue<Edge> edges(){
		System.out.println("Edges of MST:");
		for(int i = 0; i < mst.size(); i++){
			int v = mst.get(i).either();
			int w = mst.get(i).other(v);
			double weight = mst.get(i).weight();
			System.out.println(v + " -> " + w + " (weight: " + weight +")");
		}
		return mst;	
	}
	
	// @brief Print and return total weight in MST
	// @status finished
	public double weight(){
		double ret = 0.0;
		for(Edge e : mst)
			ret += e.weight();
		System.out.println("\nTotal weight of MST: " + ret);
		return ret;
	}
}
