import java.util.LinkedList;
import java.util.Queue;


public class BFSPath {
	private Graph G;
	// @brief DFSPath Constructor with give graph
	// @status finished
	public BFSPath(Graph g){
		this.G = g;
	}
	
	// @brief Print path from s to v with BFS iteration
	// @status finished
	public LinkedList<Integer> HasPathBFS(int s, int v){
		LinkedList<Integer> ret = new LinkedList<Integer>();
		int[] edgeTo = new int[G.V()];
		boolean[] marked = new boolean[G.V()];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		marked[s] = true;
		while(!queue.isEmpty()){
			int node = queue.poll();
			LinkedList<Integer> neighbors = G.adj(node);
			for(int n : neighbors){
				if(!marked[n]){
					edgeTo[node] = n;
					marked[n] = true;
					queue.add(n);
				}
			}
		}	
		if(marked[v] == false){
			System.out.println("Can not find a path from "+ s +" to " + v + "!\n");
			return ret;
		}
		for(int n = v; n != s; n = edgeTo[n])
			ret.addFirst(n);
		printPath(s, v, ret);
		return ret;
	}
	
	// @brief Helper function used for print path from s to v
	// @status finished
	private static void printPath(int s, int v, LinkedList<Integer> ret){
		System.out.print("Find path from " + s + " to " + v +"\n"+s +"->");
		for(int i = 0 ; i < ret.size(); i++){
			System.out.print(ret.get(i));
			if(i != ret.size() - 1){
				System.out.print("->");
			}
		}
		System.out.println("\n");
	}
}
