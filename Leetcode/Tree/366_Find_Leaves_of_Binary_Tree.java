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
}ß