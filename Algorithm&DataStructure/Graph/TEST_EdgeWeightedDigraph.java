import java.io.IOException;


public class TEST_EdgeWeightedDigraph {
	public static void main(String[] args) throws IOException{
		/*************** EdgeWeightedGraph ****************/
		System.out.println("@@@@@@@@@@ Create a EdgeWeightedDigraph @@@@@@@@@@\n");
		EdgeWeightedDigraph EWD = new EdgeWeightedDigraph("bin/tinyEWD.txt");
		EWD.printAdjList();
		
		//ShortestPathDijkstra:
		System.out.println("********** ShortestPath_Dijkstra Test **********\n");
		ShortestPath_Dijkstra dijkstraSP = new ShortestPath_Dijkstra(EWD, 0);
		dijkstraSP.getPathTo(1);
		dijkstraSP.getPathTo(2);
		dijkstraSP.getPathTo(3);
		dijkstraSP.getPathTo(4);
		dijkstraSP.getPathTo(5);
		dijkstraSP.getPathTo(6);
		dijkstraSP.getPathTo(7);
		dijkstraSP.getPathTo(8);

		// AcyclicSP:
		System.out.println("\n********** AcyclicSP Test **********\n");
		System.out.println("@@@@@@@@@@ Create a EdgeWeighted DAG @@@@@@@@@@\n");
		EdgeWeightedDigraph EWDAG = new EdgeWeightedDigraph("bin/tinyEWDAG.txt");
		EWDAG.printAdjList();
		AcyclicSP AcyclicSPFrom0 = new AcyclicSP(EWDAG, 0);
		AcyclicSPFrom0.getPath(2);
		AcyclicSP AcyclicSPFrom1 = new AcyclicSP(EWDAG, 1);
		AcyclicSPFrom1.getPath(2);	
		
		//ShortestPathDijkstra:
		System.out.println("********** ShortestPath_BellmanFord Test **********\n");
		System.out.println("@@@@@@@@@@ Create a EdgeWeightedDigraph with a negative cycle @@@@@@@@@@\n");
		EdgeWeightedDigraph EWDnc = new EdgeWeightedDigraph("bin/tinyEWDnc.txt");
		EWDnc.printAdjList();
		ShortestPath_BellmanFord BellmanFordSP = new ShortestPath_BellmanFord(EWDnc, 0);
		BellmanFordSP.negativeCycle();
		BellmanFordSP.getPathTo(1);
		BellmanFordSP.getPathTo(2);
		
		System.out.println("\n@@@@@@@@@@ Create a EdgeWeightedDigraph without a negative cycle @@@@@@@@@@\n");
		EdgeWeightedDigraph EWDn = new EdgeWeightedDigraph("bin/tinyEWDn.txt");
		EWDn.printAdjList();
		ShortestPath_BellmanFord BellmanFordSP2 = new ShortestPath_BellmanFord(EWDn, 0);
		BellmanFordSP2.negativeCycle();
		BellmanFordSP2.getPathTo(1);
		BellmanFordSP2.getPathTo(2);
		BellmanFordSP2.getPathTo(3);
		BellmanFordSP2.getPathTo(4);
		BellmanFordSP2.getPathTo(5);
		BellmanFordSP2.getPathTo(6);

	
	}
}
