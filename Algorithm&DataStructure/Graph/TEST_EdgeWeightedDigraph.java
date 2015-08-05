import java.io.IOException;


public class TEST_EdgeWeightedDigraph {
	public static void main(String[] args) throws IOException{
		/*************** EdgeWeightedGraph ****************/
		System.out.println("@@@@@@@@@@ Create a EdgeWeightedDigraph @@@@@@@@@@\n");
		EdgeWeightedDigraph EWD = new EdgeWeightedDigraph("bin/tinyEWD.txt");
		EWD.printAdjList();
		
		//ShortestPathDijkstra:
		System.out.println("********** ShortestPathDijkstra Test **********\n");
		ShortestPathDijkstra dijkstraSP = new ShortestPathDijkstra(EWD, 0);
		dijkstraSP.getPath(1);
		dijkstraSP.getPath(2);
		dijkstraSP.getPath(3);
		dijkstraSP.getPath(4);
		dijkstraSP.getPath(5);
		dijkstraSP.getPath(6);
		dijkstraSP.getPath(7);
		dijkstraSP.getPath(8);


//		
//		// Real-time PrimMST
//		System.out.println("\n********** Real-time PrimMST Test **********\n");
//		PrimMST primMST = new PrimMST(EWG);
//		primMST.edges(true);
//		primMST.weight();
//		
//		// KruskalMST
//		System.out.println("\n********** kruskalMST Test **********\n");
//		KruskalMST kruskalMST = new KruskalMST(EWG);
//		kruskalMST.edges();
//		kruskalMST.weight();
	}
}
