public class Solution {
    // O(1) space, O(m + n) time
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col - 1;
        while(i < row && j >= 0){
            if(target == matrix[i][j])
                return true;
            if(target > matrix[i][j])
                i++;
            else
                j--;
        }
        return false;
    }
}