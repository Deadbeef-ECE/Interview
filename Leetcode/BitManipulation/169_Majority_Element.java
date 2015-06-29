public class Solution {
    // Moore’s Voting Algorithm
    // O(1) space, O(n) time
    public int majorityElement3(int[] num) {
        if(num == null || num.length < 1)
            return -1;
        
        int index = 0;
        int cnt = 1;

        for(int i = 0; i < num.length; i++){
            if(num[i] == num[index]){
                cnt++;
            }else if(num[i]!= num[index]){
                cnt--;
                if(cnt == 0){
                    cnt = 1;
                    index = i;
                }
            }
        }
        return num[index];
    }

    // Brute Force
    // O(1) space, O(n^2) time
    public int majorityElement(int[] nums) {
        for(int i = 0; i < nums.length; i++){
        	int cnt = 1;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    if(++cnt == nums.length/2)
                        return nums[i];
                }
            }
        }
        return nums[0];
    }

    // Sort and return
    // O(1) space, O(nlogn) time
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}