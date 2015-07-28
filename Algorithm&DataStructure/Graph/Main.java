import java.io.IOException;


public class Main {
	public static void main(String[] args) throws IOException{
		Graph G = new Graph("bin/tinyG.txt");
		G.search(12);
	}
}
