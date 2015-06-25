public class FindNextBiggerNodeinBST {
	// Provide Parent Pointer
	//	  		   25
	//    	  12         39
	//     10    17   29    52
	//   8
	// running time: O(logn)
	public static TreeNode nextNode(TreeNode node){
		if (node.right != null){
			TreeNode cur = node.right;
			while (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		}else {
			TreeNode cur = node;
			while (cur.parent != null && cur == cur.parent.right) {
				cur = cur.parent;
			}
			return cur.parent;
		}
	}
	
	// NO Parent Pointer
	//	  		   25
	//    	  12         39
	//     10    17   29    52
	//   8
	// running time: O(logn)
	public static TreeNode nextNode (TreeNode root, TreeNode node) {
		if (node.right != null) {
			TreeNode cur = node.right;
			while (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		} else {
			TreeNode cur = root;
			TreeNode parent = null;
			while (cur.value != node.value) {
				if (cur.value > node.value) {
					parent = cur;
					cur = cur.left;
				} else {
					cur = cur.right;
				}
			}
			return parent;
		}
	}
	//    		  25
	//    	 12        39
	//     10  17   29    52
	//   8
	public static void main(String[] args){
		TreeNode root = new TreeNode(25);
		TreeNode node1 = new TreeNode(12);
		TreeNode node2 = new TreeNode(39);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(17);
		TreeNode node5 = new TreeNode(29);
		TreeNode node6 = new TreeNode(52);
		TreeNode node7 = new TreeNode(8);
		root.left = node1; root.right = node2;
		node1.left = node3; node1.right = node4;
		node2.left = node5; node2.right = node6;
		node3.left = node7;
		node1.parent = root; node2.parent = root;
		node3.parent = node1; node4.parent = node1;
		node5.parent = node2; node6.parent = node2;
		node7.parent = node3;
		TreeNode nextNode = nextNode(node4);
		System.out.println("Use parent pointer: The next node of node["+node4.value+"] is :"+nextNode.value);
		TreeNode nextNode2 = nextNode(root, node4);
		System.out.println("Without parent pointer: The next node of node["+node4.value+"] is :"+nextNode2.value);

	}
}
class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode(int x) {
		value = x;
		left = null;
		right = null;
		parent = null;
	}
}
