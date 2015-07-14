package onsite;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=132633&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D14%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(root == null)    return ret;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curLevel = new LinkedList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                curLevel.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            ret.add(curLevel);
        }
        return ret;
    }
}
