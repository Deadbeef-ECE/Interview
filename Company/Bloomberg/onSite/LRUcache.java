package onsite;
//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=136563&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
import java.util.HashMap;

public class LRUcache {
    class Node{
        Node prev, next;
        int key, val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    private Node head, tail;
    private int num, capacity;
    private HashMap<Integer, Node> map;
    
    public LRUcache(int capacity) {
        this.capacity = capacity+1;
        num = 0;
        map = new HashMap<Integer, Node>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null)    return -1;
        flushCache(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.val = value;
            flushCache(node);
        }else{
            node = new Node(key, value);
            appendCache(node);
            map.put(key, node);
        }
    }
    
    private void flushCache(Node node){
        if(node != tail){
            if(node == head){
                head = head.next;
            }else{
                node.prev.next = node.next;
            }
            node.next.prev = node.prev;
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }
    
    private void appendCache(Node node){
        if(head == null || tail == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        num++;
        if(num == capacity){
            map.remove(head.key);
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
            num--;
        }
    }
}
