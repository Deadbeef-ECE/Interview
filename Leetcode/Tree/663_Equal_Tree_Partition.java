class Solution {
    // 最简单的办法是先遍历一遍得到整个树的sum，然后再遍历一遍看看total - curSum == curSum?
    // 也可以把除了root节点以外的sum存到hashSet里然后到了root后再判断:
    // 1)totalSum必须是偶数才有可能
    // 2)totalSum/2是否在hashSet里
    boolean ret = false;
    Set<Integer> set = new HashSet<>();
    public boolean checkEqualTree(TreeNode root) {
        if(root == null)    return false;
        postorder(root, root);
        return ret;
    }
    
    private int postorder(TreeNode p, TreeNode root){
        if(p == null)  return 0;
        int leftSum = postorder(p.left, root);
        int rightSum = postorder(p.right, root);
        int curSum = leftSum + rightSum + p.val;
        if(p == root && curSum % 2 == 0 && set.contains(curSum/2))
            ret = true;
        set.add(curSum);
        return curSum;
    }
}