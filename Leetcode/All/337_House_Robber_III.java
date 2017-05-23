public class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        return dfs(root, map);
    }
    
    public int dfs(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null)    return 0;
        if(map.containsKey(root))   return map.get(root);
        int val = 0;
        if(root.left != null)
            val += dfs(root.left.left, map) + dfs(root.left.right, map);
        if(root.right != null)
            val += dfs(root.right.left, map) + dfs(root.right.right, map);
        val = Math.max(val + root.val, dfs(root.left, map) + dfs(root.right, map));
        map.put(root, val);
        return val;
    }
}