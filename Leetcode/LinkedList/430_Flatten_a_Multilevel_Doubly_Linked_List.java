class Solution {
    public Node flatten(Node head) {
        Node cur = head;
        while(cur != null){
            if(cur.child != null){
                Node tmp = cur.next;
                Node newNode = flatten(cur.child);
                cur.child = null;
                cur.next = newNode;
                newNode.prev = cur;
                while(cur.next != null) cur = cur.next;
                cur.next = tmp;
                // a -> null
                // |
                // b -> null
                // 此时tmp = a.next = null, null 没有prev
                if(tmp != null)
                    tmp.prev = cur;
                cur = tmp;
            }else{
                cur = cur.next;
            }
            
        }
        return head;
    }
}