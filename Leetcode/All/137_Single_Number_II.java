public class Solution {
    public int singleNumber(int[] nums) {
        // O(1) space, O(32n) => O(n) time
        int ret = 0;
        for(int i = 0; i < 32; i++){
            int cnt = 0, temp = 0;
            int mask = 1 << i;
            for(int j = 0; j < nums.length; j++){
                temp = nums[j] & mask;
                if(temp != 0){
                    cnt++;
                }
            }
            if(cnt % 3 == 1){
                ret |= mask;
            }
        }
        return ret;
    }
}