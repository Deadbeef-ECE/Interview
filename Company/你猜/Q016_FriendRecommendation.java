// 16.
// 社交网络中,如何实现好友推荐。抽象成图,然后找出共同好友最多的那个人

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class person{
	int val;
	public person(int x){	this.val = x;	}
}

class Network{
	HashMap<person, LinkedList<person>> adj;
	
	public Network(){
		this.adj = new HashMap<person, LinkedList<person>>();
	}
	
	public void addEdge(person v, person w){
		if(v.val == w.val){
			System.out.println("please~");
			return;
		}
		if(adj.containsKey(v)){
			adj.get(v).add(w);
		}else if(!adj.containsKey(v)){
			LinkedList<person> list = new LinkedList<person>();
			list.add(w);
			adj.put(v, list);
		}
		if(adj.containsKey(w)){
			adj.get(w).add(v);
		}else if(!adj.containsKey(w)){
			LinkedList<person> list = new LinkedList<person>();
			list.add(v);
			adj.put(w, list);
		}
	}
	
	public int find(person n){
		if(!adj.containsKey(n))
			System.out.println("Person not exist!");
		int[] visited = new int[adj.entrySet().size()];
		Queue<person> queue = new LinkedList<person>();
		LinkedList<person> neighbor = adj.get(n);
		for(person p : neighbor)
			queue.add(p);

		for(person m : queue){
			LinkedList<person> list = adj.get(m);
			for(person k : list){
				if(!k.equals(n) && !queue.contains(k)){
					//System.out.println("["+ k.val+"]");
					visited[k.val]++;
				}
			}
		}
		boolean find = false;
		int max = visited[0];
		int ret = 0;
		for(int i = 1; i < visited.length; i++){
			if(visited[i] > max){
				max = visited[i];
				ret = i;
				find = true;
			}
		}
		if(!find && max == 0){
			System.out.println("no recommand");
			return -1;
		}
		return ret;
	}
	
	public void printAdjList(){
		System.out.println("Adjacent List:");
		for(person i : adj.keySet()){
			System.out.print(i.val + " -> ");
			for(person j : adj.get(i)){
				System.out.print(j.val+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

public class Q016_FriendRecommendation {
	public static void main(String[] args){
		Network network = new Network();
		person p0 = new person(0);	person p1 = new person(1);
		person p2 = new person(2);	person p3 = new person(3);
		person p4 = new person(4);	person p5 = new person(5);
		person p6 = new person(6);	person p7 = new person(7);
		person p8 = new person(8);	person p9 = new person(9);
		person p10 = new person(10);person p11 = new person(11);
		person p12 = new person(12);

		network.addEdge(p0, p5);	network.addEdge(p4, p3);
		network.addEdge(p0, p1);	network.addEdge(p9, p12);
		network.addEdge(p6, p4);	network.addEdge(p5, p4);
		network.addEdge(p0, p2);	network.addEdge(p11, p12);
		network.addEdge(p10, p9);	network.addEdge(p0, p6);
		network.addEdge(p7, p8);	network.addEdge(p11, p9);
		network.addEdge(p3, p5);


		network.printAdjList();
		int ret = network.find(p0);
		System.out.println("recommand "+ ret + " for " + p0.val);
		
		int ret1 = network.find(p3);
		System.out.println("recommand "+ ret1 + " for " + p3.val);
		
		int ret2 = network.find(p5);
		System.out.println("recommand "+ ret2 + " for " + p5.val);
		
		int ret3 = network.find(p7);
		System.out.println("recommand "+ ret3 + " for " + p7.val);
		
		int ret4 = network.find(p10);
		System.out.println("recommand "+ ret4 + " for " + p10.val);
	}
}
