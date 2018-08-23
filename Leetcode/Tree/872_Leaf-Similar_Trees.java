class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        leaf(root1, list1);
        List<Integer> list2 = new LinkedList<>();
        leaf(root2, list2);
        if(list1.size() != list2.size())    return false;
        int size = list1.size();
        for(int i = 0; i < size; i++){
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }
    
    private void leaf(TreeNode root, List<Integer> list){
        if(root == null)    return;
        if(root.left == null && root.right == null)
            list.add(root.val);
        leaf(root.left, list);
        leaf(root.right, list);
    }
}