class Solution {
    boolean find = false;
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        inorder(root, k, set);
        return find;
    }
    
    private void inorder(TreeNode root, int k, HashSet<Integer> set){
        if(root == null)    return;
        if(!find){
            inorder(root.left, k, set);
            if(set.contains(k - root.val)){
                find = true;
                return;
            }
            set.add(root.val);
            inorder(root.right, k, set);
        }
    }
}