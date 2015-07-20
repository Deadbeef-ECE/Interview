public class Solution {
    // O(n * 2^n) time:
    // n为nums的length, subsets问题就是对于其中任意一个元素, 选或者不选入subset中
    // 那么, 解的个数就是2^n
    // 
    // 我们知道, subsets I的running time:
    // T(n) = n*2^(n-1) = θ(n*2^(n-1)) = O(n*2^n)
    // 但是我们知道在ret.contains()去重时, 每个解无论重复与否, 都有O(n)的时间, 所以
    // 此题中, θ(n*2^(n-1))不再成立
    // 
    // contains()到底花了多少时间?
    // 我们知道list的大小是从1逐渐增加到2^m的, m为去重后解的个数, 那么其实就是
    // 1 + 2 + 3 + ... + 2^m ~ 2^(m-1) + 2^(2m-1)
    // 这个时间是由重复元素个数决定的, 但我们可以用hashSet优化, 见subsetsWithDupOp
    // 那么最后running time还是O(n * 2^n)

    // O(n) space:
    // one n is the recursion stack
    // another n is the longest subset which is exactly the same as input 
    // nums when used this in creating new linked list to store
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if(!ret.contains(path)){
                ret.add(new LinkedList<Integer>(path));
                doDFS(i + 1, nums, path, ret);
            }
            path.remove(path.size() - 1);
        }
    }

    // HashSet优化掉contains(), 实践证明可以省掉客观时间, 尤其是对于
    // nums ＝ {1, 1, ...... 1}这样的input
    public static List<List<Integer>> subsetsWithDupOp(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        ret.add(new LinkedList<Integer>());
        if(nums == null || nums.length == 0)    return ret;
        Arrays.sort(nums);
        List<Integer> path = new LinkedList<Integer>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        doDFS(0, nums, path, set);
        for(List<Integer> entry: set){
            ret.add(entry);
        }
        return ret;
    }
    
    private static void doDFS(int start, int[] nums, List<Integer> path,  HashSet<List<Integer>> set){
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            if(!set.contains(path)){
                set.add(new LinkedList<Integer>(path));
                doDFS(i + 1, nums, path, set);
            }
            path.remove(path.size() - 1);
        }
    }
}