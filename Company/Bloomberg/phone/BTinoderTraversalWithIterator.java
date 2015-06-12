import java.util.Iterator;
import java.util.Stack;

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){
		value = x;
	}
}
public class BTinoderTraversalWithIterator {
	public class BinaryTreeIterator implements Iterator {
		  private Stack<TreeNode> stack = new Stack<TreeNode>();
		  private TreeNode root;
		  public BinaryTreeIterator(TreeNode root) {
			  this.root = root;
			  stack = new Stack<TreeNode>();
		  }
		  @Override
		  public boolean hasNext() {
			  return !stack.isEmpty() || root != null;
		  }
		
		  @Override
		  public TreeNode next() {
			  while(root != null) {
				  stack.push(root);
				  root = root.left;
			  }
			  if (stack.isEmpty()) {
				  return null;
			  }
			  TreeNode res = stack.pop();
			  root = res.right;
			  return res;
		  }
		  @Override
		  public void remove() {
		  }
	}
}
