import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		Graph G = new Graph("bin/tinyG.txt");
		G.search(12);
		G.HasPath(0, 3);
		G.HasPath(0, 5);
		G.HasPath(0, 12);
		System.out.println("end");
	}
}
