public class Solution {
    // HashSet
    // O(n) space, O(n) time
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int n : nums)
            set.add(n);
        int max = Integer.MIN_VALUE;
        
        for(int n : nums){
            int left = n - 1;
            int right = n + 1;
            int cnt = 1;
            while(set.contains(left)){
                cnt++;
                set.remove(left);
                left--;
            }
            while(set.contains(right)){
                cnt++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}