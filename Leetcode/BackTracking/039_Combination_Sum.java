public class Solution {
    // 此题time complexity无比蛋疼
    // (1) 首先来看Combination sum I和II的区别:
    // Combination sum 的input无dups, 但是input的元素可以重复利用
    // Combination sum II 的input有重复, 但是input的元素只能用一次
    // 
    // (2) 其次, 弄明白 Combination sum II的time complexity是怎么一回事儿
    // https://github.com/Deadbeef-ECE/Interview/blob/master/Leetcode/BackTracking/040_Combination_Sum_II.java
    
    // O(k * 2^n') time:
    // 此题可以转换成 combination sum II, 如何做呢, 举个栗子:
    // int[] arr = {2, 3, 4, 5, 6}, target = 10; 我们知道此题中,每个元素可以重复用, 
    // 其实, 如果把 arr 变成 {2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6}, 然
    // 后每个元素只能用一次, 就变成了combination sum II的要求了. 
    // 我们再看新数组, 元素多了很多, 多了多少? 
    // 那就是数组中所有小于等于target的元素E增加了ceil(target/E)个, 然后就可以用
    // combination sum II的方法分析复杂度了. 这里n'是新arr的大小

    // O(n) space:
    // one n is the recursion stack
    // another n is used when copying list
    // Both of them depend on the longest solution which is equal to 
    // target/(min in candidates) in this problem(可以再看下上面的例子, n就是新
    // arr中2的个数, 为ceil(10/2))
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            ret.add(sol);
            return;
        }
        for(int i = start; i < candidates.length; i++){
            path.add(candidates[i]);
            doDFS(i, candidates, target - candidates[i], path, ret);
            path.remove(path.size() - 1);
        }
    }
}