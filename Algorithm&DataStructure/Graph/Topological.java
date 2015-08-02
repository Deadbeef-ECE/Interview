import java.util.Stack;

// @breif: Topological Class
//         Topological sort
// @reference: Princeton Algorithm book P.375

public class Topological {
	private Stack<Integer> order;
	
	// @brief Topological Constructor
	// @status finished
	public Topological(Digraph G){
		DigraphCycle cyclefinder = new DigraphCycle(G);
		if(!cyclefinder.hasCycle()){
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}
	
	// @brief Topological order
	// @status finished
	public Stack<Integer> order(){
		Stack<Integer> cp = new Stack<Integer>();
		if(!order.isEmpty()){
			for(int num : order)
				cp.push(num);
		}
		System.out.println("The Topological order of this DAG: ");
		while(!cp.isEmpty())
			System.out.print(cp.pop()+" ");
		System.out.println("\n");
		return order;
	}
	
	// @brief Return if this Digraph is DAG or not
	// @status finished
	public boolean isDAG(){
		return order != null;
	}
}
