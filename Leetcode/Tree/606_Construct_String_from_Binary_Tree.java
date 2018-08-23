class Solution {
    public String tree2str(TreeNode t) {
        if (t == null)  return "";
        StringBuilder sb = new StringBuilder();
        construct(t, sb);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    private void construct(TreeNode root, StringBuilder sb){
        if(root == null)    return;
        sb.append("(");
        sb.append(root.val);
        
        if(root.left == null && root.right != null)
            sb.append("()");
        construct(root.left, sb);
        construct(root.right, sb);
        sb.append(")");
    }
}