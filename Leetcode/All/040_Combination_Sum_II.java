public class Solution {
    // O(k * 2^n) time:
    // 每个解的长度平均为k, copy list的时间复杂度是O(k)
    // 解空间:
    // 因为元素只能用一次, 所以对于长度是k的解, 解的个数最多是C(n,k)个, 而一般情况下, 
    // 解的个数远小于C(n,k), 那么问题来了, 对于长度为k的解, worst case是什么？
    // int[] arr = {1,1,1,1,1,1,1,1,1,1}  target = 2 这时候解的个数才达到C(n,k),
    // 注意: 即便在ret.add之前要去重, 我们也是在找到了可行解之后再检查是否是重复解, 所以
    //      解空间树是包含重复解的, 所以时间复杂度也包括这些重复解
    //
    // 还有一点是, 题解的长度并不是固定的, 也就是k可能有多个, 所以可能是C(n,0) ~ C(n,n)
    // 中的多个之和, 而我们知道C(n,0) + C(n,1) + C(n,2) + ... C(n,n) = 2^n
    // 所以可以把时间复杂度算成O(k * 2^n)

    // O(n) space:
    // one n is the recursion stack
    // another n is used when copying list
    // both of them depend on the longest solution which is equal to 
    // target/(all mins in candidates can be added to target) in this problem
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return ret;
        Arrays.sort(candidates);
        List<Integer> path = new LinkedList<Integer>();
        doDFS(0, candidates, target, path, ret);
        return ret;
    }
    
    private void doDFS(int start, int[] candidates, int target, 
                List<Integer> path, List<List<Integer>> ret){
        if(target < 0)  return;
        if(target == 0){
            List<Integer> sol = new LinkedList<Integer>(path);
            if(!ret.contains(sol))
                ret.add(sol);
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            path.add(candidates[i]);
            doDFS(i + 1, candidates, target - candidates[i], path, ret);
            path.remove(path.size() - 1);
        }
                       
    }
}