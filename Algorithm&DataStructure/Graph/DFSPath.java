import java.util.LinkedList;

public class DFSPath{
	private Graph  G;
	// @brief DFSPath Constructor with give graph
	// @status finished
	public DFSPath(Graph g){
		this.G = g;
	}
	
	// @brief Print path from s to v with DFS recursion
	// @status finished
	public LinkedList<Integer> HasPathDFS(int s, int v){
		LinkedList<Integer> ret = new LinkedList<Integer>();
		LinkedList<Integer> path = new LinkedList<Integer>();
		boolean[] marked = new boolean[G.V()];
		marked[s] = true;
		dfsPath(s, v, marked, path, ret);
		if(marked[v] == false){
			System.out.println("Can not find path from " + s + " to " + v + "!\n");
			return ret;
		}
		printPath(s, v, ret);
		return ret;
	}
	
	// @brief Helper function for hasPathDFS()
	// @status finished
	private void dfsPath(int s, int v, boolean[] marked, LinkedList<Integer> path, LinkedList<Integer> ret){
		if(s == v){
			ret.addAll(path);
			return;
		}
		for(int w : G.adj(s)){
			if(marked[w] == false){
				marked[w] = true;
				path.add(w);
				dfsPath(w, v, marked, path, ret);
			}
		}
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
