class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return construct(nums, 0, nums.length - 1);
    }
    
    private TreeNode construct(int[] nums, int l, int r){
        if(l > r )   return null;
        if(l == r)  return new TreeNode(nums[l]);
        int index = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[index]);
        root.left = construct(nums, l, index - 1);
        root.right = construct(nums, index + 1, r);
        return root;
    }
    
    private int findMax(int[] nums, int l, int r){
        int index = l;
        for(int i = l + 1; i <= r; i++){
            if(nums[i] > nums[index])
                index = i;
        }
        return index;
    }
}