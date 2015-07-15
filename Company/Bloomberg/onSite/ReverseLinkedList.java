package onsite;

public class ReverseLinkedList {
	public static ListNode reverseLinkedListRec(ListNode node){
		if(node.next == null)	return node;
		ListNode newHead = reverseLinkedListRec(node.next);
		node.next.next = node;
		node.next = null;
		return newHead;
	}
	
	public static ListNode reverseLinkedList(ListNode node){
		if(node == null || node.next == null)
			return node;
		ListNode dummy = new ListNode(-1);
		while(node != null){
			ListNode temp = node;
			node = node.next;
			temp.next = dummy.next;
			dummy.next = temp;
		}
		return dummy.next;
	}
	
	public static void main(String[] args){
		// 1->2->3->4->5->6 
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		printLinkedList(node1);
		ListNode ret = reverseLinkedList(node1);
		printLinkedList(ret);
	}
	
	private static void printLinkedList(ListNode node){
		while(node != null){
			System.out.print(node.val);
			if(node.next != null)
				System.out.print("->");
			node = node.next;
		}
		System.out.println();
	}
}
