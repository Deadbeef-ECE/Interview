
public class Maxstack {
	Node top = null;
    public void push(int x) {
        if(top == null){
            top = new Node(x);
            top.max = x;
        }else{
            Node temp = new Node(x);
            temp.next = top;
            temp.max = Math.max(x, top.max);
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

    public int getMax() {
        return top == null ? 0 : top.max;
    }
    
    public void printStack(){
    	Node cur = top;
    	while(cur != null){
    		System.out.print(cur.value+", ");
    		cur = cur.next;
    	}
    	System.out.println("max: "+getMax());
    	System.out.println();

    }
    
    class Node{
        int value;
        int max;
        Node next;
        public Node(int x){
            this.value = x;
        }
    }
}
