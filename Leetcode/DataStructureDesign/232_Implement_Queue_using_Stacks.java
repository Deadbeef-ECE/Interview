// Two Stacks Solution:
class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> inStack = new Stack<Integer>();
    Stack<Integer> outStack = new Stack<Integer>();

    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                int temp = inStack.pop();
                outStack.push(temp);
            }
        }
        outStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                int temp = inStack.pop();
                outStack.push(temp);
            }
        }
        return outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}