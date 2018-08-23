class Solution {
    // 要点：
    // 替换节点不要傻乎乎换pointer，换value
    // ref: http://www.cnblogs.com/grandyang/p/6228252.html
    // Recursion:
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)    return root;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null || root.right == null){
                root = root.left == null ? root.right : root.left;
            }else{
                TreeNode cur = root.right;
                while(cur.left != null)
                    cur = cur.left;
                root.val = cur.val;
                root.right = deleteNode(root.right, cur.val);
            }
        }
        return root;
    }

    // Iteration:
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root, parent = null;
        
        while(cur != null){
            if(cur.val == key)  break;
            parent = cur;
            if(cur.val > key)   cur = cur.left;
            else cur = cur.right;
        }
        if(cur == null) return root;
        if(parent == null)   return del(root);
        if(parent.left != null && parent.left.val == key)
            parent.left = del(cur);
        else
            parent.right = del(cur);
        return root;
    }
    
    private TreeNode del(TreeNode node){
        if(node.left == null && node.right == null)
            return null;
        if(node.left == null || node.right == null){
            return node.left == null ? node.right : node.left;
        }
        TreeNode cur = node.right, parent = node;
        while(cur.left != null){
            parent = cur;
            cur = cur.left;
        }
        node.val = cur.val;
        if(parent == node)
            node.right = cur.right;
        else
            parent.left = cur.right;
        return node;
    }
}