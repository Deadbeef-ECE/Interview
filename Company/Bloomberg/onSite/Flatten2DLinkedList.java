package onsite;

public class Flatten2DLinkedList {
	public static Node flatten(Node head){
		Node ret = null;
		while(head != null){
			if(head.down != null){
				Node temp = head.next;
				ret = flatten(head.down);
				head.next = head.down;
				head.down = null;
				ret.next = temp;
				head = temp;
				if(head != null && head.next == null)
					ret = head;
			}else{
				//if(head.next == null)
				ret = head;
				head = head.next;
			}
		}
		return ret;
	}
	//                 /->15->16
	// 1 -> 2 -> 3 -> 4 -> 5 -> 6
	//      \-> 7 -> 8 -> 9 ->10
	//          \->11     \->12->13->14
	//                                \-> 17->18     
	// should be
	// 1 -> 2 -> 7 -> 11 -> 8 -> 9 -> 12 -> 10 -> 3 -> 4 -> 5 -> 6 
	public static void main(String[] args){
		Node node1 = new Node(1);	Node node2 = new Node(2);
		Node node3 = new Node(3);	Node node4 = new Node(4);
		Node node5 = new Node(5);	Node node6 = new Node(6);
		Node node7 = new Node(7);	Node node8 = new Node(8);
		Node node9 = new Node(9);	Node node10 = new Node(10);
		Node node11 = new Node(11);	Node node12 = new Node(12);
		Node node13 = new Node(13);	Node node14 = new Node(14);
		Node node15 = new Node(15);	Node node16 = new Node(16);
		Node node17 = new Node(17);	Node node18 = new Node(18);

		node1.next = node2;	node2.next = node3; node3.next = node4;	node4.next = node5; node5.next = node6;
		node7.next = node8; node8.next = node9; node9.next = node10;
		node12.next = node13; node13.next = node14;
		node15.next = node16;
		node17.next = node18;
		node2.down = node7;  node7.down = node11; 
		node9.down = node12; node4.down = node15;
		node14.down = node17;
		
		print2DList(node1);
		flatten(node1);
		print2DList(node1);printList(node1);
	}

	private static void printList(Node head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	private static void print2DList(Node head){
		printListHelper(head);
		System.out.println();
	}
	private static void printListHelper(Node head){
		if(head == null)	return;
		while(head != null){
			System.out.print(head.val + " ");
			if(head.down != null){
				printListHelper(head.down);
			}
			head = head.next;
		}
	}
}
class Node{
	int val;
	Node next;
	Node down;
	public Node(int x){
		val = x;
		next = null; down = null;
	}
}