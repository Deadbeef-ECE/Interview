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
	private Stack<Integer> reversePost;
	
	// @brief DepthFirstOrder Constructor
	// @status finished
	public DepthFirstOrder(Digraph G){
		pre = new LinkedList<Integer>();
		post = new LinkedList<Integer>();
		reversePost = new Stack<Integer>();
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
		reversePost.push(v);
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
	public Stack<Integer> reversePost(){
		Stack<Integer> cp = new Stack<Integer>();
		if(!reversePost.isEmpty()){
			for(int num : reversePost)
				cp.push(num);
		}
		System.out.println("The depth first reversePost order of this Digraph: ");
		while(!cp.isEmpty())
			System.out.print(cp.pop()+" ");
		System.out.println("\n");
		return reversePost;
	}
}
