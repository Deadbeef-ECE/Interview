class Solution {
    // 繁琐而已，题目本身不难, 注意每段最后把list断开
    // O(1) space, O(n) time
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode cur = root;
        ListNode[] ret = new ListNode[k];
        while(cur != null){
            cur = cur.next;
            len++;
        }
        // k is bigger than len, need add null node
        if(len / k == 0){
            cur = root;
            int n = 0;
            while(cur != null){
                ret[n++] = cur;
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
            }
        } else{
            int size = len / k;
            int remain = len % k;
            int n = 0;
            cur = root;
            while(n != k){
                int step = remain > 0 ? size + 1 : size;
                remain = remain > 0 ? remain - 1 : 0;
                ret[n++] = cur;
                while(step > 1){
                    cur = cur.next;
                    step--;
                }
                ListNode tmp = cur.next;
                cur.next = null;
                cur = tmp;
            }
        }
        return ret;
    }
}