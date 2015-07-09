public class Solution {
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return BuildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode BuildTree(int[] nums, int start, int end){
        if(start > end) 
            return null;
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BuildTree(nums, start, mid - 1);
        root.right = BuildTree(nums, mid + 1, end);
        return root;
    }
}