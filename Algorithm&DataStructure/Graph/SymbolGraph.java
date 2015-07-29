// @breif: SymbolGraph Class
//         符号图，没有明确告知图里有多少边和多少点，input file只有每一条边
// @reference: Princeton Algorithm book P.353

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SymbolGraph {
	private HashMap<String, Integer> map;
	private String[] keys;
	private Graph G;
	
	public SymbolGraph(String in, String sp) throws IOException {
		map = new HashMap<String, Integer>();
		BufferedReader br = null; 
		BufferedReader br2 = null;
	    try { 
	        br = new BufferedReader(new FileReader(in)); 
	        String line;
	        while ((line = br.readLine()) != null) { 
        		String[] tokens = line.split(sp);
        		for(int i = 0; i < tokens.length; i++){
        			if(!map.containsKey(tokens[i]))
        				map.put(tokens[i], map.size());
        		}
	        }
        	keys = new String[map.size()];
        	for(String str : map.keySet())
        		keys[map.get(str)] = str;
        	
        	G = new Graph(map.size());
        	br2 = new BufferedReader(new FileReader(in)); 
 	        while ((line = br2.readLine()) != null) { 
         		String[] tokens = line.split(sp);
         		int v = map.get(tokens[0]);
	        	for(int i = 1; i < tokens.length; i++){
//	        		System.out.println("connect " + tokens[0] +" with " + tokens[i]);
//	        		System.out.println("connect " + v +" with " + map.get(tokens[i]));
	        		G.addEdge(v, map.get(tokens[i]));
	        	}
 	        }
	    } finally { 
	    	if (br  != null)	br.close(); 
	    	if (br2 != null)	br2.close();
	    }
	}
	
	public void printAdjList(){	G.printAdjList(); }
	public void printList(){
		System.out.println("Adjacent List with name:");
		for(int i = 0; i < G.V(); i++){
			System.out.print(keys[i] + " -> ");
			for(int j : G.adj(i)){
				System.out.print(keys[j] + " ");
			}
			System.out.println();
		}
	}
	public boolean contains(String str){
		if(!map.containsKey(str))
			System.out.println("Cannot find " + str + " in SymbolGraph!");
		return map.containsKey(str);
	}
	public int index(String str){
		if(!map.containsKey(str))	return -1;
		System.out.println(str + "'s index is " + map.get(str) + " in SymbolGraph");
		return map.get(str);
	}
	public String name(int v){
		if(v > G.V())		
			System.out.println("Error : Invalid input");
		System.out.println(v +" is corresponding with " + keys[v]);
		return keys[v];
	}
	public Graph G(){ return G;}
}
