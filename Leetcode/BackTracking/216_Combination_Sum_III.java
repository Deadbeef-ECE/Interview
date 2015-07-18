public class Solution {
    // O(k * C(9,k)) time:
    // 每个解的长度为k, copy list的时间复杂度是O(k)
    // 因为元素只能用一次, 所以解的个数最多是C(9,k)个, 一般情况下, 实际合法解的个数远
    // 小于C(9,k), 但是在没有prune的情况下, 我们要遍历所有的可能情况, 而所有可能的解
    // 就是C(9,k)

    // 举个栗子:
    // k = 3, n = 9
    // {1, 2, 3} ~ {1, 2, 9}, 其中{1, 2, 6}合法
    // {1, 3, 4} ~ {1, 3, 9}, 其中{1, 3, 5}合法
    // {1, 4, 5} ~ {1, 8, 9}, 多余支路...
    // ......... ~ .........
    // 这些支路虽然无法得到合法解, 但在找合法解的同时遍历过了, 因此也要算在时间复杂度里, 
    // 所以在这个例子中, 解空间树的支路有C(9,3)条, 也就是解空间树leaf的个数

    // O(k) space:
    // one k is the recursion stack
    // another k is used when copying list
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();
        doDFS(1, k, n, path, ret);
        return ret;
    }
    
    private void doDFS(int start, int k, int n, List<Integer> path, 
                    List<List<Integer>> ret){
        if(n < 0 || path.size() > k)    return;
        if(n == 0 && path.size() == k){
            List<Integer> sol = new LinkedList<Integer>(path);
            ret.add(sol);
            return;
        }
        
        for(int i = start; i <= 9; i++){
            path.add(i);
            doDFS(i + 1, k, n - i, path, ret);
            path.remove(path.size() - 1);
        }
    }
}