public class LRUCache {
    class Node{
        Node prev, next;
        int key;
        int val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    private Node head, tail;
    private int capacity;
    private int num;
    private HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        num = 0;
        map = new HashMap<Integer, Node>();
        head = null; tail = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null)
            return -1;
        flushCache(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.val = value;
            flushCache(node);
        }else{
            Node newNode = new Node(key, value);
            if(num >= capacity){
                map.remove(head.key);
                head = head.next;
                if(head != null)
                    head.prev = null;
                else 
                    tail = null;
                num--;
            }
            if(head == null || tail == null)
                head = newNode;
            else 
                tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            map.put(key, newNode);
            num++;
        }
    }
    
    private void flushCache(Node node){
        if(node != tail){
            if(node == head)
                head = head.next;
            else
                node.prev.next = node.next;
            node.next.prev = node.prev;
            tail.next = node;
            node.next = null;
            node.prev = tail;
            tail = node;
        }
    }
}