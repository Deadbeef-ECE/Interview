public class Solution {
    // O(n) space, O(n) time
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(root == null)    return ret;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int cnt = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new LinkedList<Integer>();
            cnt++;
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                
                if(cnt % 2 == 0)
                    level.add(temp.val);
                else
                    level.add(0, temp.val);
                    
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            ret.add(level);
        }
        return ret;
    }
}