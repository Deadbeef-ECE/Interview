// Use two Queues O(n) space
// push():O(1) time
// pop(): O(n) time
// top(): O(1) time
class MyStack {
    Queue<Integer> enQueue = new LinkedList<Integer>();
    Queue<Integer> deQueue = new LinkedList<Integer>();
    private int top;
    // Push element x onto stack.
    public void push(int x) {
        enQueue.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int ret = 0; 
        while(!enQueue.isEmpty()){
            ret = enQueue.remove();
            if(!enQueue.isEmpty()){
                top = ret;
                deQueue.add(ret);
            }
        }
        Queue temp = enQueue;
        enQueue = deQueue;
        deQueue = temp;
        
        return;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return enQueue.isEmpty() && deQueue.isEmpty();
    }
}

// Use one Queue O(n) space
// push():O(n) time
// pop(): O(1) time
// top(): O(1) time
class MyStack {
    Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while(size > 1){
            size--;
            int temp = queue.remove();
            queue.add(temp);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove();
        return;
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}