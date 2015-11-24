public class NumArray {
    SegTree tree;
    public NumArray(int[] nums) {
        tree = new SegTree(nums);
    }

    public void update(int i, int val) {
        tree.update(i, val);
    }

    public int sumRange(int i, int j) {
        return tree.sumRange(i, j);
    }
}

// O(4n) space
// http://scinart.github.io/acm/2014/03/19/acm-segment-tree-space-analysis/
// O(n) time for build tree and O(logn) time for update and sumRange
class SegTree{
    SegTreeNode root = null;
    public SegTree(int[] nums){
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private SegTreeNode buildTree(int[] nums, int start, int end){
        if(start > end) return null;
        SegTreeNode ret = new SegTreeNode(start, end);
        if(start == end){
            ret.sum = nums[start];
            return ret;
        }    
        int mid = start + (end - start)/2;
        ret.lson = buildTree(nums, start, mid);
        ret.rson = buildTree(nums, mid + 1, end);
        ret.sum = ret.lson.sum + ret.rson.sum;
        return ret;
    }
    
    public void update(int pos, int val) {
        update(root, pos, val);
    }
    
    private void update(SegTreeNode root, int pos, int val){
        if(root.start == root.end){
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start)/2;
        if(pos <= mid)
            update(root.lson, pos, val);
        else
            update(root.rson, pos, val);
        root.sum = root.lson.sum + root.rson.sum;
    }
    
    public int sumRange(int i, int j){
        SegTreeNode cur = root;
        return sumRange(cur, i, j);
    }
    
    private int sumRange(SegTreeNode root, int start, int end){
        if(root.start == start && root.end == end)
            return root.sum;
        int mid = root.start + (root.end - root.start)/2;
        if(start >= mid + 1)
            return sumRange(root.rson, start, end);
        else if(end <= mid)
            return sumRange(root.lson, start, end);
        return sumRange(root.lson, start, mid) + sumRange(root.rson, mid + 1, end);
    }
}

class SegTreeNode{
    int start, end;
    int sum;
    SegTreeNode lson, rson;
    public SegTreeNode(int start, int end){
        this.start = start;
        this.end = end;
        lson = null;
        rson = null;
        this.sum = 0;
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);