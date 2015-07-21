public class Solution {
    // O(n^2) time, O(n) space
    // => O(1) tiem, O(1) space since n is 9
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        if(row != 9 || col != 9)    return false;

        for(int i = 0; i < 9; i++){
            boolean[] table = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(table[board[i][j] - '1'] == true)
                        return false;
                    table[board[i][j] - '1'] = true;
                }
            }
        }

        for(int j = 0; j < 9; j++){
            boolean[] table = new boolean[9];
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    if(table[board[i][j] - '1'] == true)
                        return false;
                    table[board[i][j] - '1'] = true;
                }
            }
        }
        
        for(int blkNum = 0; blkNum < 9; blkNum++){
            boolean[] table = new boolean[9];
            for(int i = blkNum/3*3; i < blkNum/3*3+3; i++){
                for(int j = blkNum%3*3; j < blkNum%3*3+3; j++){
                    if(board[i][j] != '.'){
                        if(table[board[i][j] - '1'] == true)
                            return false;
                        table[board[i][j] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}