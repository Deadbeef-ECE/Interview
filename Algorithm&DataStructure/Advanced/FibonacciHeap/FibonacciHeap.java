package fibonacciHeap;
import java.util.*;
// ref: http://www.growingwiththeweb.com/data-structures/fibonacci-heap/overview/
// https://www.roading.org/algorithm/introductiontoalgorithm/%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E5%A0%86fibonacci-heaps.html
// http://www.cnblogs.com/skywang12345/p/3659060.html#a4
// http://www.cnblogs.com/gaochundong/p/fibonacci_heap.html
// http://www.cnblogs.com/junyuhuang/p/4463758.html

/* Heap operations:
 * 1) MAKE-HEAP
 * 2) INSERT
 * 3) MINIMUM
 * 4) UNION
 * 5) EXTRACT-MIN
 * 6) DECREASE-KEY
 * 7) DELETE
 */

public class FibonacciHeap<T> {
	private FibNode<T> min;
	private int size;
	
	/* MAKE-HEAP */
	public FibonacciHeap(){
		this.min = null;
		this.size = 0;
	}
	
	/* MAKE-HEAP */
	public FibonacciHeap(FibNode<T> node){
		this.min = node;
		this.size = 1;
	}
	
	/* INSERT */
	public FibNode<T> insert(int key){
		FibNode<T> node = new FibNode<T>(key);
		min = mergeLists(min, node);
		this.size++;
		return node;
	}
	
	/* UNION */
	public void union(FibonacciHeap<T> otherHeap){
		this.min = mergeLists(min, otherHeap.getMin());
		this.size += otherHeap.getSize();
	}
	
	/* MINIMUM */
	public FibNode<T> getMin(){
		return this.min;
	}
	
	/* EXTRACT-MIN */
	public FibNode<T> extractMin(){
		FibNode<T> extractedMin = getMin();
		if(extractedMin != null){
			/* All child node shouldn't have parent now */
			if(extractedMin.child != null){
				FibNode<T> child = extractedMin.child;
				do{
					child.parent = null;
					child = child.next;
				}while(child != extractedMin.child);
			}
		}
        FibNode<T> nextInRootList = min.next == min ? null : min.next;
        
        /* Remove the min from the root list */
        removeNodeFromList(extractedMin);
        this.size--;
        
        this.min = mergeLists(nextInRootList, extractedMin.child);
		
        if(nextInRootList != null){
        	this.min = nextInRootList;
        	consolidate();
        }
        
		return extractedMin;
	}
	
	private void consolidate(){
		List<FibNode<T>> aux = new ArrayList<FibNode<T>>();
		NodeListIterator<T> it = new NodeListIterator<T>(this.min);
		while(it.hasNext()){
			FibNode<T> cur = it.next();
			
			while(aux.size() <= cur.degree + 1){
				aux.add(null);
			}
			while(aux.get(cur.degree) != null){
				if(cur.key > aux.get(cur.degree).key){
					FibNode<T> temp = cur;
					cur = aux.get(cur.degree);
					aux.set(cur.degree, temp);
				}
				linkHeaps(aux.get(cur.degree), cur);
				aux.set(cur.degree, null);
				cur.degree++;
			}
			
			while(aux.size() <= cur.degree + 1){
				aux.add(null);
			}
			aux.set(cur.degree, cur);
		}
			
		/* Looping the aux to find the min */
		this.min = null;
		for(int i = 0; i < aux.size(); i++){
			if(aux.get(i) != null){
				/* Remove siblings before merging */
				aux.get(i).next = aux.get(i);
				aux.get(i).prev = aux.get(i);
				this.min = mergeLists(this.min, aux.get(i));
			}
		}
	}
	
	/* DECREASE-KEY */
	public void decreaseKey(FibNode<T> node, int key){
		if(node.key > key){
			System.out.println("ERROR: Cannot decrease the key");
			return;
		}
		
		node.key = key;
		FibNode<T> parent = node.parent;
		if(parent != null && node.key < parent.key){
			cut(node, parent);
			cascadingCut(parent);
		}
		if(node.key < min.key)
			this.min = node;
	}
	/* DELETE */ 
	public void delete(FibNode<T> node){
		decreaseKey(node, Integer.MIN_VALUE);
		extractMin();
	}
	
	/* Remove the node from its parent */
	private void cut(FibNode<T> node, FibNode<T> parent){
		removeNodeFromList(node);
		parent.degree--;
		mergeLists(min, node);
		node.marked = false;
	}
	
	private void cascadingCut(FibNode<T> node) {
		 FibNode<T> parent = node.parent;
		 if (parent != null) {
			 if (node.marked) {
				 cut(node, parent);
				 cascadingCut(parent);
			 } else {
				 node.marked = true;
			 }
		 }
	}
	
	public boolean isEmpty(){
		return this.size == 0; 
	}
	
	public void clear(){
		this.min = null;
		this.size = 0;
	}
	
	private void linkHeaps(FibNode<T> maxNode, FibNode<T> minNode) {
        removeNodeFromList(maxNode);
        min.child = mergeLists(maxNode, minNode.child);
        maxNode.parent = minNode;
        maxNode.marked = false;
    }
	private void removeNodeFromList(FibNode<T> node) {
		FibNode<T> prev = node.prev;
		FibNode<T> next = node.next;
        prev.next = next;
        next.prev = prev;
        
        node.next = node;
        node.prev = node;
    }

	// Merge two FibNodes, put newNode after minNode
	private FibNode<T> mergeLists(FibNode<T> minNode, FibNode<T> newNode){
		if(minNode == null && newNode == null)	return null;
		if(minNode == null)	return newNode;
		if(newNode == null)	return minNode;

		FibNode<T> temp = minNode.next;
		minNode.next = newNode.next;
		minNode.next.prev = minNode;
		newNode.next = temp.next;
		newNode.next.prev = newNode;
		
		return minNode.key < newNode.key ? minNode: newNode;
	}
	
	
	
	public int getSize(){
		return this.size;
	}
	
}
/* Used for consolidate method */
class NodeListIterator<T> implements Iterator<FibNode<T>> {
	private Queue<FibNode<T>> list = new LinkedList<FibNode<T>>();

	public NodeListIterator(FibNode<T> start) {
		if (start == null)
			return;

		FibNode<T> current = start;
		do {
			list.add(current);
			current = current.next;
		} while (start != current);
	}

	public boolean hasNext() {
		return list.peek() != null;
	}

	public FibNode<T> next() {
		return list.poll();
	}
}
