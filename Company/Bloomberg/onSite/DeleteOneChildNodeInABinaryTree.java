package onsite;
//http://www.1point3acres.com/bbs/thread-131230-1-1.html
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DeleteOneChildNodeInABinaryTree {
	
	public static TreeNode deleteOneChildNode(TreeNode root){
		if(root == null)	return root;
		//      <child, parent>
		HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		map.put(root, null);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			TreeNode oneChild = null;
			int cnt = 0;
			if(temp.left != null){
				queue.offer(temp.left);		cnt++;
				map.put(temp.left, temp);
			}
			if(temp.right != null){
				queue.offer(temp.right);	cnt++;
				map.put(temp.right, temp);
			}
			// one child node
			if(cnt == 1){
				oneChild = temp.left != null ? temp.left: temp.right;
				TreeNode parent = map.get(temp);
				if(parent == null){
					root = oneChild;					//return root;
				}else{
					if(parent.left.equals(temp))
						parent.left = oneChild;
					else
						parent.right = oneChild;
				}
			}
		}
		return root;
	}
	
//            25
//    	  12       39
//     10  17    29   //52
//   8
	public static void main(String[] args){
		TreeNode root = new TreeNode(25);
		TreeNode node1 = new TreeNode(12);
		TreeNode node2 = new TreeNode(39);
		TreeNode node3 = new TreeNode(10);
		TreeNode node4 = new TreeNode(17);
		TreeNode node5 = new TreeNode(29);
		//TreeNode node6 = new TreeNode(52);
		TreeNode node7 = new TreeNode(8);
		root.left = node1; root.right = node2;
		node1.left = node3; node1.right = node4;
		node2.left = node5; 
		//node2.right = node6;
		node3.left = node7;
		printTree(root);
		TreeNode ret = deleteOneChildNode(root);
		printTree(ret);
		
		//   25
		//       1
		TreeNode root1 = new TreeNode(25);
		TreeNode node_1 = new TreeNode(1);
		root1.right = node_1;
		printTree(root1);
		TreeNode ret2 = deleteOneChildNode(root1);
		printTree(ret2);
	}
	
	private static void printTree(TreeNode root){
		printTreeInorder(root);
		System.out.println();
	}
	private static void printTreeInorder(TreeNode root){
		if(root == null)	return;
		printTreeInorder(root.left);
		System.out.print(root.val+" ");
		printTreeInorder(root.right);
	}
	
	// original two hashMap version
	public static TreeNode deleteOneChildNode2(TreeNode root){
		if(root == null)	return root;
		HashMap<TreeNode, TreeNode> map1 = new HashMap<TreeNode, TreeNode>();
		HashMap<TreeNode, TreeNode> map2 = new HashMap<TreeNode, TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		map1.put(root, null);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			TreeNode oneChild = null;
			int cnt = 0;
			if(temp.left != null){
				queue.offer(temp.left);		cnt++;
				map1.put(temp.left, temp);
			}
			if(temp.right != null){
				queue.offer(temp.right);	cnt++;
				map1.put(temp.right, temp);
			}
			// one child node
			if(cnt == 1){
				oneChild = temp.left == null ? temp.right : temp.left;
				map2.put(oneChild, temp);
			}
		}
		if(map2.size() > 0){
			for(TreeNode node: map2.keySet()){
				TreeNode parent = map2.get(node);
				TreeNode grandParent = map1.get(parent);
				//System.out.println(node.val+" P: "+parent.val);
				if(grandParent != null){
					if(grandParent.left.equals(parent))	grandParent.left = node;
					else grandParent.right = node;
				}else {
					root = node;
				}
			}
		}
		return root;
	}
}
