package fibonacciHeap;

public class FibNode<T> {
	public int degree;
	public boolean marked;
	public FibNode<T> next;
	public FibNode<T> prev;
	public FibNode<T> parent;
	public FibNode<T> child;
	//private T elem;
	public int key;
	
	public FibNode(int k){
		this.key = k;
		//this.elem = elem;
		this.degree = 0;
		this.parent = null;
		this.next = this;
		this.prev = this;
		this.child = null;
		this.marked = false;
	}
	
	public int getKey(){ return this.key; }
	//public T getElem(){ return this.elem; }

	public FibNode<T> getParent(){ return this.parent; }
	
	// Set and get marked of a FibNode
	public void setMarked(boolean val){ this.marked = val; }
	public boolean isMarked(){ return this.marked; }

	// Set and get degree of a FibNode
	public void setDegree(int val){ this.degree = val; }
	public int getDegree(){ return this.degree; }
	
	
}
