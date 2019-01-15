// O(n) time, O(n) space
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if(A == null || A.length == 0)
            return 0;
        int preSum = 0;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            preSum += A[i];
            if(map.get(preSum - S) != null)
                total += map.get(preSum - S);
            if(preSum == S)
                total += 1;
            
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return total;
    }
}