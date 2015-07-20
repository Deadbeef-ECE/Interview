public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(i == size-1)
                    ret.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return ret;
    }
}