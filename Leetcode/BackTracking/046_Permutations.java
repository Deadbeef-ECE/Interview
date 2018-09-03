public class Solution {
    // O(n * n!) time:
    // 解的个数: n!, 每个解的长度: n, 故 O(n * n!) running time
    // T(n) = nT(n-1) = O(n!)

    // O(n) space:
    // one n for recursion stack
    // one n for status bool array
    // one n for created new linked list 
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return ret;
        List<Integer> path = new LinkedList<Integer>();
        boolean[] status = new boolean[nums.length];
        doDFS(nums, status, path, ret);
        return ret;
    }
    
    private void doDFS(int[] nums, boolean[] status, List<Integer> path, List<List<Integer>> ret){
        if(path.size() == nums.length && !ret.contains(path)){
            List<Integer> list = new LinkedList<Integer>(path);
            ret.add(list);
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!status[i]){
                status[i] = true;
                path.add(nums[i]);
                doDFS(nums,status, path, ret);
                path.remove(path.size() - 1);
                status[i] = false;
            }
        }
    }

    // iteration:
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if(nums == null || nums.length == 0)    return new LinkedList<>();
        List<Integer> sol = new LinkedList<>();
        list.add(sol);
        
        for(int i = 0; i < nums.length; i++){
            int size = list.size();
            for(int j = 0; j < size; j++){
                List<Integer> cur = list.remove(0);
                for(int k = 0; k < nums.length; k++){
                    if(!cur.contains(nums[k])){
                        List<Integer> next = new LinkedList<>(cur);
                        next.add(nums[k]);
                        list.add(next);
                    }
                }
            }
        }
        return list;
    }
}