public class Solution {
    // O(k * c(n,k)) time:
    // 解的个数是c(chose k from n), 也就是c(n,k), 每个解对应解空间树的一个叶节点
    // 每个解在加到ret时要copy一遍, copy的时间复杂度是O(k)
    // so, in total, the running time is O(k * c(n,k))

    // O(k) space:
    // one k is the recursion stack, another k is used when copying list
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(n < k)   return ret;
        List<Integer> path = new LinkedList<Integer>();
        doDFS(1, n, k, path, ret);
        return ret;
    }
    
    private void doDFS(int start, int n, int k, List<Integer> path, 
                        List<List<Integer>> ret){
        if(path.size() == k){
            List<Integer> sol = new LinkedList<Integer>(path);
            ret.add(sol);
            return;
        }
        for(int i = start; i <= n; i++){
            path.add(i);
            doDFS(i+1, n, k, path, ret);
            path.remove(path.size()-1);
        }
    }
}