// https://leetcode.com/problems/k-empty-slots/discuss/107948/Iterate-over-time-vs.-iterate-over-position
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        // Array of days
        int n = flowers.length;
        int[] days = new int[n];
        for(int i = 0; i < flowers.length; i++)
            days[flowers[i] - 1] = i + 1;
        
        // Search based on location
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for(int i = 0; right < n; i++) {
            // days[i] should smaller than the l and r, if not, reset window
            if(days[i] < days[left] || days[i] <= days[right]) {
                if(i == right) {
                    // Meaning between left to right-1 days[i] is greater than both ends
                    res = Math.min(res, Math.max(days[left], days[right]));
                }
                // Otherwise, reset interval
                left = i;
                right = i + k + 1;
            }
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}