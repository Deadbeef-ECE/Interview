import java.io.IOException;

public class TEST_EdgeWeightedGraph {
	public static void main(String[] args) throws IOException{
		/*************** EdgeWeightedGraph ****************/
		System.out.println("@@@@@@@@@@ Create a EdgeWeightedGraph @@@@@@@@@@\n");
		EdgeWeightedGraph EWG = new EdgeWeightedGraph("bin/tinyEWG.txt");
		EWG.printAdjList();
		
		// PrimMSTLazy:
		PrimMSTLazy lazyPrimMST = new PrimMSTLazy(EWG);
		lazyPrimMST.edges();
		lazyPrimMST.weight();
	}
}
