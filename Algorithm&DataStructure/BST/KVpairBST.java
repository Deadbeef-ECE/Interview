class TreeNode{
	int key;
	int val;
	int N; // 以该node为root的子节点个数(leaf 为0）
	TreeNode left, right;
	public TreeNode(int Key, int Val){
		key = Key;
		val = Val;
		N = 0;
	}
}


public class KVpairBST {
	private static int size(TreeNode node){
		if(node == null)	return 0;
		return node.N+1;
	}
	
	public static void insert(TreeNode root, TreeNode node){
		if(node.key > root.key){
			if(root.right != null){
				insert(root.right, node);	
			}else{
				root.right = node;
			}
		}else{
			if(root.left != null){
				insert(root.left, node);
			}else{
				root.left = node;
			}
		}
		root.N++;
		return;
	}
	
	public static int getVal(TreeNode root, int key){
		while(root != null){
			if(key > root.key){
				root = root.right;
			}else if(key < root.key){
				root = root.left;
			}else{
				return root.val;
			}
		}
		System.out.format("Cannot find target with key[%d]\n", key);
		return -1;
	}
	
	public static void put(TreeNode root, int key, int val){
		while(root != null){
			if(key > root.key){
				root = root.right;
			}else if(key < root.key){
				root = root.left;
			}else{
				root.val = val;
				return;
			}
		}
		System.out.format("Cannot find target with key[%d]\n", key);
		return;
	}
	// find the node which node.key >= key, key can be any normal value
	public static int ceilRec(TreeNode root, int key){
		if(root == null)
			return Integer.MIN_VALUE;
		if(root.key == key)
			return key;
		if(root.key < key)
			return ceilRec(root.right, key);
		int ret = ceilRec(root.left, key);
		return ret >= key ? ret : root.key;
	}
	// find the node which node.key <= key, key can be any normal value
	public static int floorRec(TreeNode root, int key){
		if(root == null)
			return Integer.MAX_VALUE;
		if(root.key == key)
			return key;
		if(root.key > key)
			return floorRec(root.left, key);
		int ret = floorRec(root.right, key);
		return ret <= key ? ret : root.key;
	}
	// find the next smallest node larger than key, 
	// if cannot find key, return -1;
	public static int findSuccessor(TreeNode root, int key){
		if(root.right == null)
			return -1;
		if(root.key <= key)
			return findSuccessor(root.right, key);
		int ret = findSuccessor(root.left, key);
		return ret > key ? ret: root.key;
	}
	// find the previous biggest node smaller than key, 
	// if cannot find key, return MAX;
	public static int findPredecessor(TreeNode root, int key){
		if(root.right == null)
			return Integer.MAX_VALUE;
		if(root.key >= key)
			return findPredecessor(root.left, key);
		int ret = findPredecessor(root.right, key);
		return ret < key ? ret: root.key;
	}
	// delete min in the BST
	public static void deleteMin(TreeNode root){
		root = deletemin(root);
	}
	private static TreeNode deletemin(TreeNode node){
		if(node.left == null)	return node.right;
		node.left = deletemin(node.left);
		node.N--;
		return node;
	}
	// delete max in the BST
	public static void deleteMax(TreeNode root){
		root = deletemax(root);
	}
	private static TreeNode deletemax(TreeNode node){
		if(node.right == null)	return node.left;
		node.right = deletemax(node.right);
		node.N--;
		return node;
	}
	// delete certain node according to key
	public static void Delete(TreeNode root, int key){
		root = delete(root, key);
	}
	private static TreeNode delete(TreeNode root, int key){
		if(root == null)	return null;
		if(key > root.key){
			root.right = delete(root.right, key);
		}else if(key < root.key){
			root.left = delete(root.left, key);
		}else{
			if(root.right == null) return root.left;
			if(root.left == null)	return root.right;
			TreeNode tmp = root;
			root = min(tmp.right);
			root.right = deletemin(tmp.right);
			root.left = tmp.left;
		}
		root.N = size(root.left) + size(root.right);
		return root;
	}
	// Get the min in the BST
	public static int Min(TreeNode root){
		return min(root).key;
	}
	private static TreeNode min(TreeNode root){
		if(root.left == null)	return root;
		return min(root.left);
	}
	// Get the max in the BST
	public static int Max(TreeNode root){
		return max(root).key;
	}
	private static TreeNode max(TreeNode root){
		if(root.right == null)
			return root;
		return max(root.right);
	}
	//          50
	//     35           75
	//   20  40     63     90
	// 12     43  55  73 80
	public static void main(String[] args){
		TreeNode root = new TreeNode(50, 0);
		insert(root, new TreeNode(35, 0));
		insert(root, new TreeNode(75, 0));
		insert(root, new TreeNode(20, 0));
		insert(root, new TreeNode(40, 0));
		insert(root, new TreeNode(63, 0));
		insert(root, new TreeNode(90, 90));
		insert(root, new TreeNode(12, 0));
		insert(root, new TreeNode(43, 0));
		insert(root, new TreeNode(55, 0));
		insert(root, new TreeNode(73, 0));
		insert(root, new TreeNode(80, 0));
		printTree(root);
		System.out.println();
		put(root, 90, 1135);
		int val1 = getVal(root, 90);
		int minKey = Min(root);
		int Treesize = size(root);
		int ceilNum = ceilRec(root, 35);
		int floorNum = floorRec(root, 35);
		int ceilNum2 = ceilRec(root, 25);
		int floorNum2 = floorRec(root, 25);
		int nextSmllest = findSuccessor(root, 43);
		int prevLargest = findPredecessor(root, 43);

		System.out.println("Tree size: "+Treesize);
		System.out.println("Min: "+ minKey);
		System.out.println("Ceil of 25: "+ ceilNum2);
		System.out.println("floor of 25: "+ floorNum2);
		System.out.println("Ceil of 35: "+ ceilNum);
		System.out.println("floor of 35: "+ floorNum);
		System.out.println("Successor of 43: "+ nextSmllest);
		System.out.println("Predecessor of 43: "+ prevLargest);

//		deletemin(root);
//		deletemax(root);
//		printTree(root);
//		System.out.println("\nTree size: "+size(root));
		
		delete(root, 35);
		printTree(root);
		System.out.println("\nTree size: "+size(root));
		System.out.println("end");
	}
	
	public static void printTree(TreeNode root){
		if(root == null) 	return;
		printTree(root.left);
		System.out.print(root.key + "["+root.N+"]" +" ");
		printTree(root.right);
	}
}
