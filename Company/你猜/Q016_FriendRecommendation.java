// 16.
// 社交网络中,如何实现好友推荐。抽象成图,然后找出共同好友最多的那个人

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class person{
	int val;
	public person(int x){
		this.val = x;
	}
}

class Network{
	int V; // person
	int E; // edges
	LinkedList<person>[] adj;
	
	// create graph from input file
	public Network(String in) throws IOException{
		BufferedReader br = null; 
	    try { 
	        br = new BufferedReader(new FileReader(in)); 
	        String line;
	        int cnt = 0;
	        while ((line = br.readLine()) != null) { 
	        	//System.out.println(line);
	        	cnt++;
	        	if(cnt == 1){
	        		this.V = Integer.parseInt(line);
	        		adj = new LinkedList[this.V];
	        		for(int i = 0; i < V; i++){
	        			adj[i] = new LinkedList<person>();
	        		}
	        	}else if(cnt == 2) {
	        		this.E = Integer.parseInt(line);
	        		System.out.println("Network has "+ this.V + " people and "+this.E+" relations");
	        	}else{
	        		String[] tokens = line.split(" ");
		        	int v = Integer.parseInt(tokens[0]); 
		        	int w = Integer.parseInt(tokens[1]);
		        	addEdge(v, w);
	        	}
	        } 
	    } finally { 
	    	if (br != null) br.close(); // dont throw an NPE because the file wasn't found.
	    }
	}
	
	public int E(){	return this.E;	}
	public int V(){	return this.V;	}
	
	public void addEdge(int v, int w){
		this.adj[v].add(new person(w));
		this.adj[w].add(new person(v));
		E++;
	}
	
	public int find(int n){
		if(n > this.V)
			System.out.println("Person not exist!");
		int[] visited = new int[this.V];
		Queue<Integer> queue = new LinkedList<Integer>();
		LinkedList<person> neighbor = this.adj[n];
		for(person p : neighbor){
			queue.add(p.val);
		}
		for(int m : queue){
			LinkedList<person> list = this.adj[m];
			for(person k : list){
				if(k.val != n && !queue.contains(k)){
					System.out.println("["+ k.val+"]");
					visited[k.val]++;
				}
			}
		}
		
		int max = visited[0];
		int ret = 0;
		for(int i = 1; i < this.V; i++){
			if(visited[i] > max){
				max = Math.max(max, visited[i]);
				ret = i;
			}
		}
		return ret;
	}
	
	public void printAdjList(){
		System.out.println("Adjacent List:");
		for(int i = 0; i < this.V; i++){
			System.out.print(i + " -> ");
			for(person j : this.adj[i]){
				System.out.print(j.val+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

public class Q016_FriendRecommendation {
	public static void main(String[] args) throws IOException{
		Network network = new Network("bin/016.txt");
		network.printAdjList();
		int ret = network.find(0);
		System.out.println("recommand: "+ ret);
	}
}
