public class MovingAverage {
    Deque<Integer> q;
    int num;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new ArrayDeque(size);
        num = size;
    }
    
    public double next(int val) {
        int total = q.size() == num ? num : q.size() + 1;
        int sum = val;
        if(q.size() == num)
            q.removeFirst();
        for(int n : q)
            sum += n;
        
        q.addLast(val);
        return (double)sum/(double)total;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

// Basic LinkedList implementation
class MovingAverage {
    Node dummy;
    Node cur;
    int sum;
    int n;
    int curSize;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        dummy = new Node(-1);
        cur = dummy;
        sum = 0;
        n = size;
    }
    
    public double next(int val) {
        Node newNode = new Node(val);
        cur.next = newNode;
        cur = cur.next;
        sum += val;
        curSize++;
        if(curSize > n){
            sum -= dummy.next.val;
            dummy = dummy.next;
            curSize--;
        }
        
        return (double)sum / (double)curSize;
    }
}

class Node{
    Node next;
    Node prev;
    int val;
    
    public Node(int v){
        this.val = v;
        next = null;
        prev = null;
    }
}