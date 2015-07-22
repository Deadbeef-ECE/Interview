public class Solution {
    // O(n) time, O(1) space
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0;
        int sum = 0;
        int start = 0;
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            diff = gas[i] - cost[i];
            sum += diff;
            total += diff;
            if(sum < 0){
                sum = 0;
                start = i+1;
            }
        }
        if(total < 0)
            return -1;
        return start;
    }
}