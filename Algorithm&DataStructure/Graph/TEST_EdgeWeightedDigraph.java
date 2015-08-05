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

		// AcyclicSP:
		System.out.println("\n********** AcyclicSP Test **********\n");
		System.out.println("@@@@@@@@@@ Create a EdgeWeighted DAG @@@@@@@@@@\n");
		EdgeWeightedDigraph EWDAG = new EdgeWeightedDigraph("bin/tinyEWDAG.txt");
		EWDAG.printAdjList();
		AcyclicSP AcyclicSPFrom0 = new AcyclicSP(EWDAG, 0);
		AcyclicSPFrom0.getPath(2);

		AcyclicSP AcyclicSPFrom1 = new AcyclicSP(EWDAG, 1);
		AcyclicSPFrom1.getPath(2);	
	}
}
