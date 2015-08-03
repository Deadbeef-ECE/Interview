import java.io.IOException;

public class TEST_DAG {
	public static void main(String[] args) throws IOException{
		/*************** DAG ****************/
		System.out.println("\n@@@@@@@@@@ Create a DAG @@@@@@@@@@\n");

		// DepthFirstOrder:
		System.out.println("********** DepthFirstOrder Test **********\n");
		Digraph DAG = new Digraph("bin/tinyDAG.txt");
		DAG.printAdjList();
		DepthFirstOrder depthfirstorder = new DepthFirstOrder(DAG);
		depthfirstorder.pre();
		depthfirstorder.post();
		depthfirstorder.reversePost();
		
		// Topological:
		System.out.println("********** Topological Test **********\n");
		Topological topo = new Topological(DAG);
		topo.order();
	}
}
