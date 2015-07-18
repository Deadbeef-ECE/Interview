public class Solution {
    // TODO: time complexity and space complexity analysis
    // O() time
    // O() space
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