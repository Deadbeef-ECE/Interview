public class Solution {
    // TODO: 
    // O() time
    // O() space
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
}