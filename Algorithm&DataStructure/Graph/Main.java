import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		Graph G = new Graph("bin/tinyG.txt");
		G.printAdjList();
		G.search(12);
		// DFS:
		G.HasPathDFS(0, 3);
		G.HasPathDFS(0, 5);
		G.HasPathDFS(0, 12);
		
		// BFS:
		G.HasPathBFS(0, 3);
		G.HasPathBFS(0, 5);
		G.HasPathBFS(0, 12);
		System.out.println("end");
	}
}
