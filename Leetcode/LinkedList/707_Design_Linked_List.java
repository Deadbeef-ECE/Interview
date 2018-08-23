class MyLinkedList {
    ListNode head;
    ListNode tail;
    int len;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = tail = null;
        len = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= len || index < 0)    return -1;
        ListNode cur = head;
        while(index > 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = tail = newNode;
            len++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        len++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = tail = newNode;
            len++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        len++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > len || index < 0)
            return;
        if(index == len){
            addAtTail(val);
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while(index > 1){
            cur = cur.next;
            index--;
        }
        ListNode next = cur.next;
        cur.next = newNode;
        newNode.prev = cur;
        newNode.next = next;
        next.prev = newNode;
        len++;
        return;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= len || index < 0)
            return;
        if(len == 1){
            head = tail = null;
            len--;
            return;
        }
        if(index == len - 1){
            tail = tail.prev;
            tail.next = null;
            len--;
            return;
        }
        if(index == 0){
            head = head.next;
            head.prev = null;
            len--;
            return;
        }
        ListNode cur = head;
        while(index > 1){
            cur = cur.next;
            index--;
        }
        ListNode next = cur.next.next;
        cur.next = next;
        next.prev = cur;
        len--;
    }
}
class ListNode{
    ListNode next;
    ListNode prev;
    int val;
    public ListNode(int v){
        this.next = this.prev = null;
        this.val = v;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */