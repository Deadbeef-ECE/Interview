public class Solution {
    //ref: https://discuss.leetcode.com/topic/80793/java-o-n-time-o-k-space
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(k != 0)  sum %= k;
            if(map.containsKey(sum)){
                int idx = map.get(sum);
                if(i - idx > 1) return true;
            }else{
                map.put(sum, i);
            }
        }
        return false;
    }
}