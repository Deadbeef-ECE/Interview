public class Solution {
    // DFS Recursion:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public boolean isSymmetric(TreeNode root) {
        if(root == null)    return true;
        return isSymmetricRec(root.left, root.right);
    }
    
    private boolean isSymmetricRec(TreeNode left, TreeNode right){
        if(left == null)    return right == null;
        if(right == null)   return false;
        if(left.val != right.val)   return false;
        if(!isSymmetricRec(left.left, right.right))
            return false;
        if(!isSymmetricRec(left.right, right.left))
            return false;
        return true;
    }

    // BFS Iteration:
    // O(n) space, n is the leaf number since we need to add null into the queue
    // O(n) time
    public boolean isSymmetric2(TreeNode root) {
        if(root == null)    return true;
        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
        left.add(root.left);
        right.add(root.right);
        while(!left.isEmpty() && !right.isEmpty()){
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            if((l == null && r != null) || (l != null && r == null))
                return false;
            if(l != null){
                if(l.val != r.val)  return false;
                left.add(l.left);
                left.add(r.left);
                right.add(r.right);
                right.add(l.right);  
            }
        }
        return true;
    }
}