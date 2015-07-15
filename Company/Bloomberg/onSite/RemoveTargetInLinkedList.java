package onsite;
// on-site question:
// remove target node in a linked list whitout dups
// this version is my own follow up to consider dups in the list
public class RemoveTargetInLinkedList {
	public static ListNode deleteNode(ListNode head, int target){
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		while(cur != null){
			if(cur.val != target){
				prev.next = cur;
				prev = cur;
			}
			cur = cur.next;			
		}
		prev.next = cur;
		return dummy.next;
	}
	
	public static void main(String[] args){
		// 1->2->3->3->2->1 
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(1);
		ListNode node7 = new ListNode(1);
		ListNode node8 = new ListNode(1);
		ListNode node9 = new ListNode(1);
		node1.next = node2;node2.next = node3;
		node3.next = node4;node4.next = node5;
		node5.next = node6;node6.next = node7;
		node7.next = node8;node8.next = node9;
		int target = 1;
		printList("Original List:", node1);
		System.out.println("Want to remove " + target);
		ListNode ret = deleteNode(node1, target);
		printList("After remove target: ", ret);
	}
	
	private static void printList(String str, ListNode head){
		System.out.println(str);
		while(head != null){
			System.out.print(head.val);
			if(head.next != null)
				System.out.print("->");
			head = head.next;
		}
		System.out.println();
	}
}
