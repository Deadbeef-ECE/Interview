import java.util.Stack;


public class EdgeWeightedDirectedCycle {
	private int[] marked;
	private DirectedEdge[] edgeTo;
	private Stack<DirectedEdge> cycle;
	
	// @brief DigraphCycle Constructor
	// @status finished
	public EdgeWeightedDirectedCycle(EdgeWeightedDigraph G){
		edgeTo = new DirectedEdge[G.V()];
		marked = new int[G.V()];
		for(int v = 0; v < G.V(); v++)
			if(marked[v] == 0) dfs(G, v);
	}
	
	// @brief dfs helper function of DigraphCycle
	// @status finished
	private void dfs(EdgeWeightedDigraph G, int v){
		marked[v] = -1;
		for(DirectedEdge e : G.adj(v)){
			int w = e.to();
			if(cycle != null)	return;
			else if(marked[w] == 0){
				edgeTo[w] = e;
				dfs(G, w);
			}else if(marked[w] == -1){
				cycle = new Stack<DirectedEdge>();
                while (e.from() != w) {
                    cycle.push(e);
                    e = edgeTo[e.from()];
                }
                cycle.push(e);
			}
		}
		marked[v] = 1;
	}
	
	// @brief Return if the Digraph has cycle or not
	// @status finished
	public boolean hasCycle(){
		return cycle != null;
	}
	
	// @brief Print and return the first detected cycle in Digraph
	// @status finished
	public Stack<DirectedEdge> cycle(){
		Stack<DirectedEdge> cp = new Stack<DirectedEdge>();
		if(!cycle.isEmpty()){
			for(DirectedEdge num : cycle){
				cp.push(num);
			}
		}
		
		while(!cp.isEmpty()){
			DirectedEdge e = cp.pop();
			System.out.print(e.from() +" -> " + e.to() + "(weight: " + e.weight() + ") ");
		}
		System.out.println();
		return cycle;
	}
}
