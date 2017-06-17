class Node{
    Node prev, next;
    int key, val;
    public Node(int key, int val){
        this.prev = null;
        this.next = null;
        this.key = key;
        this.val = val;
    }
}
// 思路清晰版本
public class LRUCache {
    private int num;
    private int count;
    private Node head, tail;
    private HashMap<Integer, Node> map; 
    
    public LRUCache(int capacity) {
        this.num = 0;
        this.count = capacity;
        this.map = new HashMap<Integer, Node>();
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n == null)   return -1;
        flush(n);
        return n.val;
    }

    // 1) if key alredy exists, flush 
    // 2) non-exsits: create a new one
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n != null){
            n.val = value;
            flush(n);
        }else{
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if(num == count)
                evict();
            insertToLast(newNode);
        }
    }
    // 1) if n is already last one, return;
    // 2) if head == tail, means head = tail = n, return;
    // 3) if n is head, move head forward;
    // 4) if n is in the middle, remove from middle, addlast
    private void flush(Node n){
        if(head == tail || tail == n)
            return;
        Node next = n.next;
        next.prev = n.prev;
        if(n.prev == null)
            head = next;
        else
            n.prev.next = n.next;
        n.prev = null; n.next = null;
        num--;
        insertToLast(n);
    }
    
    // 1) if empty list: set head and tail
    // 2) if not empty: append and move tail forward
    private void insertToLast(Node newNode){
        if(head == null){
            head = newNode;
            tail = head;
        }else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        num++;
    }
    // 1) remove key from hashmap
    // 2) if only node left
    // 3) else move head forward
    private void evict(){
        if(head == null)    return;
        map.remove(head.key);
        if(head == tail){
            head = null;
            tail = null;
        }else{
            Node temp = head.next;
            temp.prev = null;
            head.next = null;
            head = temp;
        }
        num--;
    }
}