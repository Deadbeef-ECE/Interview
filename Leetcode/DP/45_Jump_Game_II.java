public class Solution {
    // 不太像DP, 自己的版本
    // O(1) space, O(n) time
    public int jump(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int maxDistance = nums[0];
        int nextDistance = nums[0];
        int step = 1;
        for(int i = 1; i <= maxDistance; i++){
        	if(maxDistance >= nums.length - 1)
                return step;
        	if(nums[i] + i > nextDistance){
            	nextDistance = nums[i] + i;
            }
        	if(i == maxDistance){
            	step++;
            	maxDistance = nextDistance;
        	}
        }
        return 0;
    }

    // 简洁版本, 别人家答案, 感觉自己家答案牛逼点
    // 对于A = {0,0,0} 这种走不到最后的input, 此答案作废
    public int jump2(int[] A) {
        if(A.length <= 1)
            return 0;
        int step = 0;
        int MaxDist = 0;
        int NextMaxDist = 0;
        for(int i = 0; i < A.length; i++){
            if(i > MaxDist){
                MaxDist = NextMaxDist;
                step++;
            }
            NextMaxDist = Math.max(NextMaxDist, i+A[i]);
        }
        return step;
    }
}