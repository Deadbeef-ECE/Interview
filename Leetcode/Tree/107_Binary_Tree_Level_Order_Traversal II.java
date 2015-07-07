public class Solution {
    // O(n) space, O(n) time
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(root == null)    return ret;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            Linked<Integer> level = new LinkedList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            ret.add(0, level);
        }
        return ret;
    }
}