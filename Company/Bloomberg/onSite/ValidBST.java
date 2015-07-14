package onsite;

import java.util.Stack;

// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=131230&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

public class ValidBST {
	// Recursion Solution:
	// O(1) space OR O(logn) space if consider recursion stack
	// O(n) time
	private static TreeNode prev;
	public static boolean isValidRec(TreeNode root){
		if(root == null)	return true;
		if(!isValid(root.left))	
			return false;
		
		if(prev != null && prev.val > root.val)
			return false;
		prev = root;
		
		if(!isValid(root.right))	
			return false;
		return true;
	}
	
	// Iteration Solution:
	public static boolean isValid(TreeNode root){
		if(root == null)	return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root);
		TreeNode prev = null;
		while(!stack.isEmpty()){
			if(root != null && root.left != null){
				stack.push(root.left);
				root = root.left;
			}else{
				TreeNode temp = stack.pop();
				if(temp.right != null){
					root = temp.right;
					stack.push(temp.right);
				}
				if(prev != null && prev.val >= temp .val)
					return false;
				prev = temp;
			}
		}
		return true;
	}
	
	//	         25
	//    	  12       39
	//     10  17   29    52
	//   8
	public static void main(String[] args){
		TreeNode root = new TreeNode(25);
		TreeNode node1 = new TreeNode(12);
		TreeNode node2 = new TreeNode(39);
		TreeNode node3 = new TreeNode(30);
		TreeNode node4 = new TreeNode(17);
		TreeNode node5 = new TreeNode(29);
		TreeNode node6 = new TreeNode(52);
		TreeNode node7 = new TreeNode(8);
		root.left = node1; root.right = node2;
		node1.left = node3; node1.right = node4;
		node2.left = node5; node2.right = node6;
		node3.left = node7;
		System.out.println(isValidRec(root));
		System.out.println(isValid(root));
	}
}
