public class Solution {
    // TODO: time complexity and space complexity analysis
    // O() time
    // O() space
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