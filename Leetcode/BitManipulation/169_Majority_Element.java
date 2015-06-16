public class Solution {
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

	// Moore’s Voting Algorithm
	// O(1) space, O(n) time
    
}