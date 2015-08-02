// @breif: DigraphCycle Class
//         Detect cycle in Digraph
// @reference: Princeton Algorithm book P.372

import java.util.Stack;

public class DigraphCycle {
	private int[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	
	// @brief DigraphCycle Constructor
	// @status finished
	public DigraphCycle(Digraph G){
		edgeTo = new int[G.V()];
		marked = new int[G.V()];
		for(int v = 0; v < G.V(); v++)
			if(marked[v] == 0) dfs(G, v);
	}
	
	// @brief dfs helper function of DigraphCycle
	// @status finished
	private void dfs(Digraph G, int v){
		marked[v] = -1;
		for(int w : G.adj(v)){
			if(this.hasCycle())	return;
			else if(marked[w] == 0){
				edgeTo[w] = v; 
				dfs(G, w);
			}else if(marked[w] == -1){
				cycle = new Stack<Integer>();
				for(int x = v; x != w; x = edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
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
	public Stack<Integer> cycle(){
		Stack<Integer> cp = new Stack<Integer>();
		if(!cycle.isEmpty()){
			for(int num : cycle){
				cp.push(num);
			}
		}
		
		while(!cp.isEmpty()){
			System.out.print(cp.pop()+" ");
		}
		System.out.println();
		return cycle;
	}
}
