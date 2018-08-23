class Solution {
    // Level order traversal with dequeue
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)    return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int ret = 1;
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = deque.poll();
                if(cur == null){
                    deque.add(null);
                    deque.add(null);
                }else{
                    TreeNode left = cur.left == null ? null : cur.left;
                    TreeNode right = cur.right == null ? null : cur.right;
                    deque.add(left);
                    deque.add(right);
                }
            }
            while(!deque.isEmpty() && deque.getFirst() == null)
                deque.removeFirst();
            while(!deque.isEmpty() && deque.getLast() == null)
                deque.removeLast();
            int width = deque.size();
            if(width > ret) ret = width;
        }
        return ret;
    }
}