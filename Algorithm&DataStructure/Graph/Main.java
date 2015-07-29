import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		Graph G = new Graph("bin/tinyG.txt");
		G.printAdjList();
		G.search(12);
		
		// DFS:
		System.out.println("********** DFS Test **********\n");
		G.HasPathDFS(0, 3);
		G.HasPathDFS(0, 5);
		G.HasPathDFS(0, 12);
		
		// BFS:
		System.out.println("********** BFS Test **********\n");
		G.HasPathBFS(0, 3);
		G.HasPathBFS(0, 5);
		G.HasPathBFS(0, 12);
		
		// Connected Component:
		System.out.println("********** CC Test **********\n");
		CC cc = new CC(G);
		cc.count();
		cc.id(0);	cc.id(3);	cc.id(4);	cc.id(6);
		cc.id(7);	cc.id(8);
		cc.id(10);	cc.id(12);
		System.out.println();
		/* should be connected */
		cc.isConnected(0, 5);
		cc.isConnected(7, 8);
		cc.isConnected(9, 11);
		/* should be not connected */
		cc.isConnected(0, 7);
		cc.isConnected(7, 10);
		cc.isConnected(9, 3);

		System.out.println("end");
	}
}
