// @breif: DepthFirstOrder Class
//         Three kinds of DepthFirstOrder in Digraph:
//         (1) pre order; (2) post order; (3) reversePost order
// @reference: Princeton Algorithm book P.374

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {
	private boolean[] marked;
	private LinkedList<Integer> pre;
	private LinkedList<Integer> post;
	
	private Stack<Integer> reversePostStack;
	private LinkedList<Integer> reversePost;
	
	// @brief DepthFirstOrder Constructor with Digraph
	// @status finished
	public DepthFirstOrder(Digraph G){
		pre = new LinkedList<Integer>();
		post = new LinkedList<Integer>();
		reversePostStack = new Stack<Integer>();
		reversePost = new LinkedList<Integer>();
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++){
			if(!marked[v])
				dfs(G, v);
		}
	}
	
	// @brief dfs helper function of DepthFirstOrder
	// @status finished
	private void dfs(Digraph G, int v){
		pre.add(v);
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G, w);
		}
		post.add(v);
		reversePostStack.push(v);
	}
	
	// @brief DepthFirstOrder Constructor with EdgeWeightedDigraph
	// @status finished
	public DepthFirstOrder(EdgeWeightedDigraph G) {
		pre = new LinkedList<Integer>();
		post = new LinkedList<Integer>();
		reversePostStack = new Stack<Integer>();
		reversePost = new LinkedList<Integer>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }
	
	// @brief dfs helper function of DepthFirstOrder
	// @status finished
    private void dfs(EdgeWeightedDigraph G, int v) {
        marked[v] = true;
        pre.add(v);
        for (DirectedEdge e : G.adj(v)) {
            if (!marked[e.to()]) {
                dfs(G, e.to());
            }
        }
        post.add(v);
        reversePostStack.push(v);
    }
	
	// @brief Print and return depth first pre order of this Digraph
	// @status finished
	public Queue<Integer> pre(){
		System.out.println("The depth first pre order of this Digraph: ");
		for(int i = 0; i < pre.size(); i++)
			System.out.print(pre.get(i)+" ");
		System.out.println("\n");
		return pre;
	}
	
	// @brief Print and return depth first post order of this Digraph
	// @status finished
	public Queue<Integer> post(){		
		System.out.println("The depth first post order of this Digraph: ");
		for(int i = 0; i < post.size(); i++)
			System.out.print(post.get(i)+" ");
		System.out.println("\n");
		return post;
	}
	
	// @brief Print and return depth first reversePost order of this Digraph
	// @status finished
	public LinkedList<Integer> reversePost(){
		System.out.println("The depth first reversePost order of this Digraph: ");
		while(!reversePostStack.isEmpty()){
			int s = reversePostStack.pop();
			System.out.print(s + " ");
			reversePost.add(s);
		}
		System.out.println("\n");
		return reversePost;
	}
}
