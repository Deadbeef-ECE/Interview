public class Solution {
    // O(n^2) time, O(1) space
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return ret;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int l = i + 1, r = nums.length - 1;
                while(l < r){
                    if(nums[i] + nums[l] + nums[r] == 0){
                        List<Integer> sol = new LinkedList<Integer>();
                        sol.add(nums[i]);
                        sol.add(nums[l]);
                        sol.add(nums[r]);
                        ret.add(sol);
                        l++; r--;
                        while(l < r && nums[l] == nums[l-1])
                            l++;
                        while(l < r && nums[r] == nums[r+1])
                            r--;
                    }else if(nums[i] + nums[l] + nums[r] > 0){
                        r--;                    
                    }else{
                        l++;
                    }
                }    
            }
        }
        return ret;
    }
}