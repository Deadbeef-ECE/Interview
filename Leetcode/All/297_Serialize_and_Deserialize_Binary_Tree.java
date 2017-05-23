/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// LevelOrder Solution
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null)    return "N";
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append("N,");   
            }
            else{
                sb.append(cur.val).append(',');
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split("\\,");
        if (nodes.length == 1) return null;
    
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i = 1;           // starting from the second node if root is not null
    
        while (i < nodes.length) {
            TreeNode node = queue.poll();
    
            String left = nodes[i++], right = nodes[i++];
            if (!left.equals("N")) {
                TreeNode lChild = new TreeNode(Integer.parseInt(left));
                node.left = lChild;
                queue.offer(lChild);
            }
            if (!right.equals("N")) {
                TreeNode rChild = new TreeNode(Integer.parseInt(right));
                node.right = rChild;
                queue.offer(rChild);
            }
        }
        return root;
    }
}

// PreOrder Solution
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "N";
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    private void preorder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("\\,");
        Deque<String> nodes = new LinkedList<String>(Arrays.asList(arr));
        return helper(nodes);
    }
    
    private TreeNode helper(Deque<String> list){
        if (list.size() == 0) return null;
        String str = list.pop();
        if (str.equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = helper(list);
        root.right = helper(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));