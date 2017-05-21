public class Solution {
    // BFS: 
    public void connect(TreeLinkNode root) {
        if(root == null)    return;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        queue.add(null);
        
        while(!queue.isEmpty()){
            TreeLinkNode cur = queue.poll();
            if(cur != null){
                cur.next = queue.peek();
                if(cur.left != null)    
                    queue.add(cur.left);
                if(cur.right != null)   
                    queue.add(cur.right);
            }else{
                if(!queue.isEmpty()) 
                    queue.add(null);
            }
        }
    }

    // Recursion:
    public void connect(TreeLinkNode root) {
        if(root == null)    return;
        TreeLinkNode p = root.next;
        
        while(p != null){
            if(p.left == null && p.right == null){
                p = p.next;
            }else if(p.left != null){
                p = p.left;
                break;
            }else if(p.right != null){
                p = p.right;
                break;
            }
        }
        if(root.right != null){
            root.right.next = p;
        }
        if(root.left != null){
            root.left.next = root.right == null? p: root.right;
        }
        connect(root.right);
        connect(root.left);
    }
}