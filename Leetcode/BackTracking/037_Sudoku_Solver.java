public class Solution {
    // O(n^m) time:
    // n is all the possible number in each cell and m is the number of empty cells
    // The running time of isValid() function is O(1) time since the board is 9*9

    // O(m) space:
    // The recursion tree has maximum m heigh in which m is the number of empty cells
    public void solveSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9)
            return;
        solve(board);
    }
    
    private boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char num = '1'; num <= '9'; num++){
                        if(isValid(board, i, j, num)){
                            board[i][j] = num;
                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    // after tried all possible number, still cannot solve, return false
                    return false; 
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char num){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == num)
                return false;
        }
        
        for(int j = 0; j < 9; j++){
            if(board[row][j] == num)
                return false;
        }
        
        for(int i = row/3*3; i < row/3*3+3; i++){
            for(int j = col/3*3; j < col/3*3+3; j++){
                if(board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
}