public class Solution {
    // Recursion:
    // O(n^2) space, O(n^2) time ?
    public List<TreeNode> generateTrees(int n) {
        return generator(1, n);
    }
    
    private List<TreeNode> generator(int left, int right){
        List<TreeNode> ret = new LinkedList<TreeNode>();
        if(left > right){
            ret.add(null);
            return ret;
        } 
        
        for(int i = left; i <= right; i++){
            List<TreeNode> leftSubTree = generator(left, i-1);
            List<TreeNode> rightSubTree = generator(i+1, right);
            for(int j = 0; j < leftSubTree.size(); j++){
                for(int k = 0; k < rightSubTree.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree.get(j);
                    root.right = rightSubTree.get(k);
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}