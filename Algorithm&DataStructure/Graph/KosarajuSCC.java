// @breif: KosarajuSCC Class(based on Kosaraju Algorithm)
//         SCC means Strong Connected Component 即强连通分量
//         注: 这是DAG里的一个概念
// @reference: Princeton Algorithm book P.378
//             http://blog.csdn.net/dm_vincent/article/details/8554244
// @Complexity: O(V + E) time

// 2. 伪代码
//•　　step1：对原图G进行深度优先遍历，记录每个节点的离开时间。
//•　　step2：选择具有最晚离开时间的顶点，对反图GT进行遍历，删除能够遍历到的顶点，这些顶点构成一个强连通分量。
//•　　step3：如果还有顶点没有删除，继续step2，否则算法结束。

public class KosarajuSCC {
	private boolean[] marked;
	private int[] id;
	private int count;
	 
	// @brief Constructor of KosarajuSCC with Digraph G as input
	// @status finished
	public KosarajuSCC(Digraph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for(int s : order.reversePost()){
			if(!marked[s]){
				dfs(G, s);
				count++;
			}
		}
	}
	
	// @brief DFS helper function used for mark Connected Component
	// @status finished
	private void dfs(Digraph G, int v){
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G, w);
		}
	}

	// @brief Check give nodes v and w is strongly connected or not
	// @status finished
	public boolean isStronglyConnected(int v, int w){
		System.out.print("\nv: "+ v + " w: "+ w);
		if(id[v] == id[w]){
			System.out.print(" is strongly connected with same id: "+ id[v]);
		}else{
			System.out.print(" is NOT stronly connected!");
			System.out.print("id[" + v + "]: " + id[v] + " id[" + w + "]:" + id[w]);
		}
		return id[v] == id[w];
	}
	
	// @brief Return id of given node
	// @status finished
	public int id(int v){
		System.out.println("id[" + v + "] is " + id[v]);
		return id[v];
	}
	
	// @brief return the number of strongly connected componenets in this digraph
	// @status finished 
	public int count(){
		System.out.println("There are " + count + " SCC in this Digraph\n");
		return count;
	}
}
