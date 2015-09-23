public class Solution {
    // 一路异或得到的是两个single的异或 a^b = diff
    // diff&=-diff得到最低位异或为1的mask，即这个1只出现在a或b的一个数字
    // 然后原数组继续分两组异或，分别得到这两个数
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num : nums)
            diff ^= num;
        diff &= -diff;
        int[] ret = {0, 0};
        for(int num : nums){
            if((num & diff) == 0)
                ret[0] ^= num;
            else
                ret[1] ^= num;
        }
        return ret;
    }
}