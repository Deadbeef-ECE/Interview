/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        
        int[] ret = new int[list.size()];
        for(int i = 0; i < ret.length; i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
    
    public void helper(TreeNode root, List<Integer> list){
        if(root == null)    return;
        helper(root.left, list);
        if(prev != null){
            if(prev.val == root.val)
                count++;
            else
                count = 1;
        }
        if(count > max){
            max = count;
            list.clear();
            list.add(root.val);
        }else if(count == max){
            list.add(root.val);
        }
        prev = root;
        helper(root.right, list);
    }
}