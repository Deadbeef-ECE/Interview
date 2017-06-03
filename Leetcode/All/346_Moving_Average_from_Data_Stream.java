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