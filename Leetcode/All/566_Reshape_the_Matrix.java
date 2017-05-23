public class Solution {
    // O(n) time, O(1) space
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int r1 = nums.length;
        int c1 = nums[0].length;
        if(r1 * c1 != r * c)    return nums;
        int[][] ret = new int[r][c];
        for(int i = 0; i < r ; i++){
            for(int j = 0; j < c; j++){
                int cur = i * c + j;
                int r2 = cur / c1;
                int c2 = cur % c1;
                ret[i][j] = nums[r2][c2];
            }
        }
        return ret;
    }
}