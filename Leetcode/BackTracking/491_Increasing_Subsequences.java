class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if(nums == null || nums.length == 0)
            return new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        dfs(0, nums, path, set);
        return new ArrayList<>(set);
    }
    
    private void dfs(int pos, int[] nums, List<Integer> path, Set<List<Integer>> set){
        if(path.size() >= 2){
            set.add(new ArrayList<>(path));
        }
        for(int i = pos; i < nums.length; i++){
            if(path.size() == 0 || nums[i] >= path.get(path.size() - 1)){
                path.add(nums[i]);
                dfs(i + 1, nums, path, set);
                path.remove(path.size() - 1);
            }
        }
    }
}