class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new int[]{1, i, i});
            }else{
                int[] arr = map.get(nums[i]);
                arr[0]++;
                arr[2] = i;
            }
        }
        
        int degree = Integer.MIN_VALUE, ret = Integer.MAX_VALUE;
        for(int[] value : map.values()){
            if(value[0] > degree){
                degree = value[0];
                ret = value[2] - value[1] + 1;
            }else if(value[0] == degree)
                ret = Math.min(ret, value[2] - value[1] + 1);
        }
        return ret;
    }
}