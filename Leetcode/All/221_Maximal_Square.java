public class Solution {
    // 二维DP:
    // O(n^2) space, O(n^2) time
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        
        for(int i = 0; i < row; i++){
            dp[i][0] = matrix[i][0] - '0';
        }
        for(int j = 0; j < col; j++){
            dp[0][j] = matrix[0][j] - '0';
        }
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int ret = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dp[i][j] > ret)
                    ret = dp[i][j];
            }
        }
        return ret*ret;
    }
}