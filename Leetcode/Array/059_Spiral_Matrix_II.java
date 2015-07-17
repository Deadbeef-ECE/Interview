public class Solution {
    // O(n^2) space, O(n^2) time
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, top = 0;
        int right = n-1, bottom = n-1;
        int k = 1;
        while(left <= right && top <= bottom){
            int i, j;
            for(j = left; j <= right; j++)
                matrix[top][j] = k++;
                
            for(i = top+1; i <= bottom; i++)
                matrix[i][right] = k++;
                
            for(j = right-1; j >= left; j--)
                matrix[bottom][j] = k++;
                
            for(i = bottom-1; i >= top+1; i--)
                matrix[i][left] = k++;
            top++;
            bottom--;
            left++;
            right--;
        }
        return matrix;
    }
}