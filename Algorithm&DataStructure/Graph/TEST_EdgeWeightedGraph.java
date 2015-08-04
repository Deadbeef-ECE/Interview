import java.io.IOException;

public class TEST_EdgeWeightedGraph {
	public static void main(String[] args) throws IOException{
		/*************** EdgeWeightedGraph ****************/
		System.out.println("@@@@@@@@@@ Create a EdgeWeightedGraph @@@@@@@@@@\n");
		EdgeWeightedGraph EWG = new EdgeWeightedGraph("bin/tinyEWG.txt");
		EWG.printAdjList();
		
		// PrimMSTLazy:
		System.out.println("********** PrimMSTLazy Test **********\n");
		PrimMSTLazy lazyPrimMST = new PrimMSTLazy(EWG);
		lazyPrimMST.edges();
		lazyPrimMST.weight();
		
		// Real-time Prim
		System.out.println("\n********** Real-time Prim Test **********\n");
		PrimMST primMST = new PrimMST(EWG);
		primMST.edges(true);
		primMST.weight();
	}
}
