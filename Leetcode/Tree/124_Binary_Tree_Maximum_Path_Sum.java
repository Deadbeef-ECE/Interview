public class Solution {
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public int maxPathSum(TreeNode root) {
        if(root == null)    return 0;
        int[] max = {Integer.MIN_VALUE};
        maxPathSumRec(root, max);
        return max[0];
    }
    
    private int maxPathSumRec(TreeNode root, int[] max){
        if(root == null)    return 0;
        int leftSum = maxPathSumRec(root.left, max);
        int rightSum = maxPathSumRec(root.right, max);
        int rootVal = root.val;
        // return 的值必须是单边的最大和(root.val, root.val+leftSum, root.val+rightSum),
        // 不能考虑子树, 因为上层递归要用到, 若cur考虑子树(ootVal+leftSum+rightSum), 那么上层
        // 递归计算的数值就是这个样子, 就不再是两个node之间的距离:
        //      1 -> cur上层
        //    3 -> cur
        //  2   1
        int cur = Math.max(rootVal, Math.max(rootVal + leftSum, rootVal + rightSum));
        max[0] = Math.max(max[0], Math.max(cur, rootVal + leftSum + rightSum));
        return cur;
    }
}