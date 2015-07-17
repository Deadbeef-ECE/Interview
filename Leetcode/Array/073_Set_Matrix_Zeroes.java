public class Solution {
    // O(1) space, O(n^2) time
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 0 || col == 0)
            return;
        
        boolean rowHasZero = false;
        boolean colHasZero = false;
        // check first row has 0 or not
        for(int i = 0; i < col; i++){
            if(matrix[0][i] == 0)
                rowHasZero = true;
        }
        // check first col has 0 or not
        for(int j = 0; j < row; j++){
            if(matrix[j][0] == 0)
                colHasZero = true;
        }
        //find zeros and store the info in the first row and col
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // set zeros
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(rowHasZero){
            for(int j = 0; j < col; j++)
                matrix[0][j] = 0;
        }
        if(colHasZero){
            for(int i = 0; i < row; i++)
                matrix[i][0] = 0;
        }
    }
}