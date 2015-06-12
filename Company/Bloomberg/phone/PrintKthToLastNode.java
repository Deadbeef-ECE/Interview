//write a function that will print the contents of the k-th to last
//element in a linked list
//input: Head of the linked list (Node type), and integer k.
//assume the node class has next(), and value()
class Node{
	int value;
	Node next;
	public Node(int x){
		value = x;
	}
	public Node next(){
		return this.next;
	}
	public int value(){
		return this.value;
	}
}
public class PrintKthToLastNode {
	public static void printKthToLastNodes(Node head, int k) {

	    if(k < 0 || head == null) {
	        System.out.println("ERROR: Invalid input!");
	        return;
	    }
	    
	    Node pFast = head;
	    Node pSlow = head;

	    int i = 0;
	    while(i < k && pFast.next() != null) {
	        pFast = pFast.next();
	        i++;
	    }
	    if(i < k) {
	        System.out.println("k is more than the length of the linkedlist");
	        return;
	    }
	    while(pFast != null) {
	        pSlow = pSlow.next();
	        pFast = pFast.next();
	    }

	    System.out.println(pSlow.value());
//	    while(pSlow!=null) {
//      System.out.println(pSlow.value());
//      pSlow = pSlow.next();
//  }
	    return;
	}
}
