public class Solution {
    // Reverse List Solution:
    // O(1) space, O(n) time
    // 此解法是要recover原list
    public boolean isPalindrome(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    
        ListNode slow = dummy;
        ListNode fast = dummy;
        while( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow.next);
        boolean result = true;
        while( left != null && right != null ){
            if( !result ){
                break;
            }
            if(left.val != right.val ){
                result = false;
            }
            left = left.next;
            right = right.next;
        }
        right = reverse(right);
        slow.next = right;
        return result;
    }

    private ListNode reverse(ListNode node){
        ListNode head = new ListNode(0);
        while(node != null){
            ListNode tmp = node;
            node = node.next;
            tmp.next = head.next;
            head.next = tmp;
        }
        return head.next;
    }

    // 不需要recover原list的简洁答案
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow.next);
        while(left != null && right != null){
            if(left.val != right.val)   return false;
            left = left.next;
            right = right.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode node){
        if(node.next == null)   return node;
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
    // HashMap Brute-Force:
    // O(n) space, O(n) time
    public boolean isPalindrome(ListNode head) {
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            if(map.containsKey(cur.val)){
                Set<Integer> set = map.get(cur.val);
                set.add(len);
            }else{
                Set<Integer> newSet = new HashSet<Integer>();
                newSet.add(len);
                map.put(cur.val, newSet);
            }
            cur = cur.next;
            len++;
        }
        if(len == 1)    return true;
        for(int val : map.keySet()){
            Set<Integer> set = map.get(val);
            for(int pos : set){
                if(!set.contains(len - pos - 1))
                    return false;
            }
        }
        return true;
    }
}