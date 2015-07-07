public class Solution {
	// DFS Recursion:
	// O(1) space OR O(logn) space if consider recursion stack
	// O(n) time
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null)   return q == null;
        if(q == null)   return false;
        if(p.val != q.val)  return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // BFS Interation:
    // O(n) space, O(n) time
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(p);
        q2.add(q);
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode cur1 = q1.poll();
            TreeNode cur2 = q2.poll();
            if(cur1 == null && cur2 == null)    continue;
            if(cur1 == null || cur2 == null)
                return false;
            if(cur1.val != cur2.val)    return false;
            q1.add(cur1.left);
            q1.add(cur1.right);
            q2.add(cur2.left);
            q2.add(cur2.right);
        }
        return q1.size() == q2.size();
    }
}