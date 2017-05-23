public class Solution {
    // BFS: 此方法通用 I/II
    public void connect(TreeLinkNode root) {
        if(root == null)    return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeLinkNode temp = queue.poll();
            if(temp != null){
                temp.next = queue.peek();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }else{
                if(!queue.isEmpty())
                    queue.add(null);
            }
        }
    }

    // Recursion
    public void connect(TreeLinkNode root) {
        if(root == null)    return;
        if(root.left != null)
            root.left.next = root.right;
        if(root.right != null)
            root.right.next = root.next == null? null: root.next.left;
        connect(root.left);
        connect(root.right);
    }
}