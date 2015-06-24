public class Solution {
    // 不太像DP, 自己的版本
    // O(1) space, O(n) time
    //   i
    //  {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}
    //   |____________________|
    //    maxDistance(nums[0])
    //   7, 7, 11,9,13,11, 7, 14 (nextDistance from i to maxDistance)
    //   when i == maxDistance, step+=1 and update maxDistance = nextDistance
    //   then next round, until maxDistance >= nums.length - 1

    public int jump(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int maxDistance = nums[0];
        int nextDistance = nums[0];
        int step = 1;
        for(int i = 1; i <= maxDistance; i++){
        	if(maxDistance >= nums.length - 1)
                return step;
            nextDistance = Math.max(nums[i] + i, nextDistance);
        	if(i == maxDistance){
            	step++;
            	maxDistance = nextDistance;
        	}
        }
        return 0;
    }

    // 别人家解法, 感觉还是自己家解法牛逼点,因为对于nums = {0,0,0}这种走不到最后
    // 的input, 此解法作废(突然觉得自己好机智)
    public int jump2(int[] nums) {
        if(A.length <= 1)
            return 0;
        int step = 0;
        int MaxDist = 0;
        int NextMaxDist = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > MaxDist){
                MaxDist = NextMaxDist;
                step++;
            }
            NextMaxDist = Math.max(NextMaxDist, i + nums[i]);
        }
        return step;
    }
}