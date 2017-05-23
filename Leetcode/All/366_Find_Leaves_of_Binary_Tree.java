public class Solution {
    // 思路清晰版本:
    public List<List<Integer>> findLeaves(TreeNode root) {
        int depth = depth(root);  
        List<List<Integer>> results = new ArrayList<>(depth);  
        for(int i = 0; i < depth; i++) {  
            results.add(new ArrayList<>());  
        }  
        depth(root, results);  
        return results;  
    }
    
    private int depth(TreeNode node, List<List<Integer>> results) {  
        if (node == null) return 0;  
        int depth = 1;  
        int left = depth(node.left, results);  
        int right = depth(node.right, results);  
        depth += Math.max(left, right);  
        results.get(depth - 1).add(node.val);  
        return depth;  
    }  

    private int depth(TreeNode node) {  
        if (node == null) return 0;  
        int depth = 1;  
        int left = depth(node.left);  
        int right = depth(node.right);  
        depth += Math.max(left, right);  
        return depth;  
    }  
    // 简洁版本: 边遍历边加node:
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();  
        if(root == null)    return ret;
        helper(root, ret);
        return ret;
    }
    
    public int helper(TreeNode root, List<List<Integer>> ret){
        if(root == null)    return -1; // -1是因为index of list从0 开始
        int l = helper(root.left, ret);
        int r = helper(root.right, ret);
        int depth = Math.max(l, r) + 1;
        if(ret.size() == depth)
            ret.add(new ArrayList<Integer>());
        ret.get(depth).add(root.val);
        return depth;
    }
}