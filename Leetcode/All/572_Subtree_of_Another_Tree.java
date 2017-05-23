public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)   return t == null;
        if(t == null)   return false;
        if(isSame(s, t))    return true;
        if(isSubtree(s.left, t) || isSubtree(s.right, t))
            return true;
        return false;
    }
    
    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null || t == null)   return s == t;
        if(s.val != t.val)  return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}