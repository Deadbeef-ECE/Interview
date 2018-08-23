class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int preLen = pre.length, postLen = post.length;
        return build(pre, 0, preLen - 1, post, 0, postLen - 1);
    }
    
    private TreeNode build(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd){
        if(preEnd < preStart)    return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if(preEnd == preStart)  return root;
        int idx = postStart;
        while(idx < postEnd){
            if(pre[preStart + 1] == post[idx])
                break;
            idx++;
        }
        int len = idx - postStart + 1;
        root.left = build(pre, preStart + 1, preStart + len, post, postStart, idx);
        root.right = build(pre, preStart + len + 1, preEnd, post, idx + 1, postEnd - 1);
        return root;
    }
}