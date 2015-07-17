public class Solution {
    // O(1) space, O(n^2) time
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length != matrix[0].length)
            return;
        int n = matrix.length;
        // matrix[n-1-j][i]     =>  matrix[i][j]       
        // matrix[n-1-i][n-1-j] <=  matrix[j][n-1-i] 
        int t = n % 2 == 0 ? n/2: (n+1)/2;
        for(int i = 0; i < t; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
        return;
    }

    // O(1) space, O(n^2) time
    public void rotate2(int[][] matrix) {
        if(matrix.length != matrix[0].length)
            return;
        int n = matrix.length;
        // a | b  =>  b | a
        // c | d      d | c
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        // b   a  =>  c  a
        // d / c      d  b
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1-i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = temp;
            }
        }
    }
}