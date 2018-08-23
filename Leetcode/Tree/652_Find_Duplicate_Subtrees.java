class Solution {
    // encode to string and store into HashMap for checking duplicate
    // ref: https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/java-concise-postorder-traversal-solution
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ret = new LinkedList<>();
        if(root == null)    return ret;
        postorder(root, new HashMap<>(), ret);
        return ret;
    }
    
    private String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> ret){
        if(cur == null)    return "#";
        String encode = cur.val + postorder(cur.left, map, ret) + "," + postorder(cur.right, map, ret);
        if(map.getOrDefault(encode, 0) == 1)    ret.add(cur);
        map.put(encode, map.getOrDefault(encode, 0) + 1);
        return encode;
    }

    //还一种更牛逼的解法，用global number value:
    //https://www.youtube.com/watch?v=LYU3y0-59_k
}