import java.io.IOException;


public class TEST_Digraph {
	public static void main(String[] args) throws IOException{
		/*************** Digraph ****************/
		System.out.println("\n@@@@@@@@@@ Create a Digraph @@@@@@@@@@\n");
		Digraph digraph = new Digraph("bin/tinyDG.txt");
		digraph.printAdjList();

		// DigraphDFS:
		System.out.println("********** DigraphDFS Test **********\n");
		DigraphDFS digraphDFS = new DigraphDFS(digraph);
		digraphDFS.search(12);
		digraphDFS.search(0);
		digraphDFS.search(6);
		
		// DigraphCycle:
		System.out.println("********** DigraphCycle Test **********\n");
		DigraphCycle digraphcycle = new DigraphCycle(digraph);
		digraphcycle.cycle();
		
		// Connected Component:
		System.out.println("********** KosarajuSCC Test **********\n");
		digraph.printAdjList();
		KosarajuSCC scc = new KosarajuSCC(digraph);
		scc.count();
		scc.id(0);	scc.id(1);
		scc.id(3);	scc.id(4);	scc.id(6);
		scc.id(7);	scc.id(8);
		scc.id(10);	scc.id(12);
		/* should be strongly connected */
		scc.isStronglyConnected(0, 5);
		scc.isStronglyConnected(9, 11);
		/* should be not strongly connected */
		scc.isStronglyConnected(7, 8);
		scc.isStronglyConnected(0, 7);
		scc.isStronglyConnected(7, 10);
		scc.isStronglyConnected(9, 3);
	}
	
}
