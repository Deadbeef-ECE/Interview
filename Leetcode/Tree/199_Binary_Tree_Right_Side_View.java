public class Solution {
    // BFS
    // O(n) space, O(n) time
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(i == size - 1)
                    ret.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return ret;
    }

    // DFS
    // O(1) Or O(height) space, O(n) time
    int level = 0;;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        inorder(root, 1, ret);
        return ret;
    }
    
    private void inorder(TreeNode root, int curLevel, List<Integer> ret){
        if(root == null)    return;
        if(curLevel > level){
            ret.add(root.val);
            level = curLevel;
        }
        inorder(root.right, curLevel+1, ret);
        inorder(root.left, curLevel+1, ret);
    }
}