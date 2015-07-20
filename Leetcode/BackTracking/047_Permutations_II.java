public class Solution {
    // TODO:
    // O() time:
    // O() space:
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return ret;
        List<Integer> path = new LinkedList<Integer>();
        Arrays.sort(nums);
        boolean[] status = new boolean[nums.length];
        doDFS(nums, status, path, ret);
        return ret;
    }
    
    private void doDFS(int[] nums, boolean[] status, List<Integer> path, List<List<Integer>> ret){
        if(path.size() == nums.length){
            List<Integer> list = new LinkedList<Integer>(path);
            ret.add(list);
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && status[i-1] == false)
                continue;
            if(!status[i]){
                status[i] = true;
                path.add(nums[i]);
                doDFS(nums, status, path, ret);
                path.remove(path.size()-1);
                status[i] = false;
            }
        }
    }
}