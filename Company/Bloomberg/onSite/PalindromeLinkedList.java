package onsite;

public class PalindromeLinkedList {
	public static boolean isPalindrome(ListNode node){
		if(node == null || node.next == null)
			return true;
		ListNode dummy = new ListNode(-1);
		dummy.next = node;
		
		ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = node;
        ListNode berforereverse = slow;
        ListNode reverseStart = slow.next;
        ListNode right = reverse(reverseStart);
        
        reverseStart = right;
        boolean result = true;
        while( left != null && right != null ){
            if(!result)
                break;
            if(left.val != right.val ){
                result = false;
            }
            left = left.next;
            right = right.next;
        }
        right = reverse(reverseStart);
        berforereverse.next = right;
		return result;
	}
	
	private static ListNode reverse(ListNode node){
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
		// 1->2->3->3->2->1 
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		printLinkedList(node1);
		System.out.println(isPalindrome(node1));
		printLinkedList(node1);

	}
	// O(n) space, O(n) time
	public static boolean isPalindrome2(ListNode node){
		if(node == null)	return false;
		if(node.next == null)	return true;
		String str = "";
		while(node != null){
			str += node.val;
			node = node.next;
		}
		int lo = 0, hi = str.length() - 1;
		while(lo <= hi){
			if(str.charAt(lo) != str.charAt(hi))
				return false;
			lo++;
			hi--;
		}
		return true;
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
