public class Solution {
    // O(n * 2^n) time:
    // n为nums的length, subsets问题就是对于其中任意一个元素, 选或者不选入subset中
    // 那么, 解的个数就是2^n
    // 
    // 然后举个栗子: nums = {1, 2, 3, 4}
    // 解空间树:
    //             1                  2         3       4       null
    //         /    \     \         /   \      /
    //       12      13   14      23    24    34
    //      /  \     /            /
    //    123  124  134         234
    //    /  
    //  1234      
    //            8(个)            4(个)       2(个)    1(个)    1(个)
    // 16个(in total) = 2^4
    // 
    // 可以从这个例子中看到, running time严格来讲是:
    // T(n) = 0xC(n,0) + 1xC(n,1) + 2xC(n,2) + ... + nxC(n,n)        (1)
    // 我们知道C(n,k) = C(n, n-k), 那么:
    // T(n) = 0xC(n,n) + 1xC(n,n-1) + 2xC(n,n-2) + ... + nxC(n,0)    (2)
    // (1) + (2) = 2T(n) = nxC(n,0) + nxC(n,1) + ...+ nxC(n,n)
    //                   = nx(C(n,0) + C(n,1) + ...+ C(n,n)) = n2^n
    // 然后得到:
    // T(n) = n*2^(n-1) = θ(n*2^(n-1)) = O(n*2^n)

    // O(n) space:
    // one n is the recursion stack
    // another n is the longest subset which is exactly the same as input 
    // nums when used this in creating new linked list to store
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        ret.add(new LinkedList<Integer>());
        if(nums == null || nums.length == 0)    return ret;
        Arrays.sort(nums);
        List<Integer> path = new LinkedList<Integer>();
        doDFS(0, nums, path, ret);
        return ret;
    }
    
    private void doDFS(int start, int[] nums, List<Integer> path, List<List<Integer>> ret){
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            ret.add(new LinkedList<Integer>(path));
            doDFS(i + 1, nums, path, ret);
            path.remove(path.size() - 1);
        }
    }
}