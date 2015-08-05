// @breif: Topological Class
//         Topological sort
// @reference: Princeton Algorithm book P.375

import java.util.LinkedList;

public class Topological {
	private LinkedList<Integer> order;
	
	// @brief Topological Constructor with Digraph
	// @status finished
	public Topological(Digraph G){
		DigraphCycle cyclefinder = new DigraphCycle(G);
		if(!cyclefinder.hasCycle()){
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}
	
	// @brief Topological Constructor with EdgeWeightedDigraph
	// @status finished
	public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }
	
	// @brief Topological order
	// @status finished
	public LinkedList<Integer> order(){
		System.out.println("The Topological order of this DAG: ");
		for(int i: order)
			System.out.print(i+" ");
		System.out.println("\n");
		return order;
	}
	
	// @brief Return if this Digraph is DAG or not
	// @status finished
	public boolean isDAG(){
		return order != null;
	}
}
