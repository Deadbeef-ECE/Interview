class MedianFinder {
    // left is MaxPQ, right part is MinPQ.
    // O(n) space
    // O(logn) add + O(1) find
    private PriorityQueue<Integer> minPQ;
    private PriorityQueue<Integer> maxPQ;
    private int mid;
    
    public MedianFinder(){
        minPQ = new PriorityQueue<Integer>();
        maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(minPQ.size() == 0){
            minPQ.add(num);
            return;
        }
        if(maxPQ.size() == 0){
            maxPQ.add(num);
            return;
        }
        if(minPQ.size() == 1 && maxPQ.size() == 1 && minPQ.peek() < maxPQ.peek()){
            int x = minPQ.poll();
            int y = maxPQ.poll();
            minPQ.add(y);
            maxPQ.add(x);
        }
        if(num < maxPQ.peek())  maxPQ.add(num);
        else minPQ.add(num);
        int s1 = maxPQ.size();
        int s2 = minPQ.size();
        if(s2 - s1 == 2)
            maxPQ.add(minPQ.poll());
        if(s1 - s2 == 2)
            minPQ.add(maxPQ.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        int s1 = minPQ.size();
        int s2 = maxPQ.size();
        if(s1 == s2)
            return (minPQ.peek() + maxPQ.peek())/2.0;
        return s1 > s2 ? minPQ.peek() : maxPQ.peek();
    }
};

// More excellent solution:
class MedianFinder {
    private Queue<Long> small = new PriorityQueue(),
                        large = new PriorityQueue();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());
        if (small.size() > large.size()){
            large.add(-small.poll());
        }
    }

    public double findMedian() {
        return small.size() < large.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
    }
};
