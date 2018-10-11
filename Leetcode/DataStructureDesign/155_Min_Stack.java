// Linked List实现
class MinStack {
    Node top = null;
    public void push(int x) {
        if(top == null){
            top = new Node(x);
            top.min = x;
        }else{
            Node temp = new Node(x);
            temp.next = top;
            temp.min = Math.min(x, top.min);
            top = temp;
        }
    }

    public void pop() {
        Node temp = top;
        top = top.next;
        temp.next = null;
    }

    public int top() {
        return top == null ? 0 : top.value;
    }

    public int getMin() {
        return top == null ? 0 : top.min;
    }
    
    class Node{
        int value;
        int min;
        Node next;
        public Node(int x){
            this.value = x;
        }
    }
}
// 内置stack实现
class MinStack {
    Stack<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}