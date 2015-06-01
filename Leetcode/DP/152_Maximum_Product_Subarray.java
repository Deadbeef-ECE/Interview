public class Solution {
    // DP, 只需要俩常数, O(1) space, O(1) time
    public int maxProduct(int[] A) {
        int dpMax = A[0];
        int dpMin = A[0];
        int max = A[0];
        for(int i = 1; i < A.length; i++){
            int tempMax = dpMax;   // dpmax在dpmin更新前已经更新了, 要记录下
            dpMax = Math.max(Math.max(A[i] * dpMax, A[i]), A[i] * dpMin);
            dpMin = Math.min(Math.min(A[i] * dpMin, A[i]), A[i] * tempMax);
            max = Math.max(dpMax, max);
        }
        return max;
    }
}