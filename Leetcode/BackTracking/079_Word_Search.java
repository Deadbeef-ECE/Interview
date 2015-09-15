public class Solution {
    // O(m*n*k) time: k is the length of the word
    // worst case example
    // e.g: find eat
    //      e a e a
    //      a e a e
    //      e a e a
    //      a e a t
    // O(m*n) space: one copy of board
    private int row, col;
    private boolean find;
    private boolean[][] status;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)  return false; 
        row = board.length;
        col = board[0].length;
        find = false;
        status = new boolean[row][col];
        search(board, word);
        return find;
    }
    
    private void search(char[][] board, String word){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                dfs(i, j, 0, board, word);
            }
        }
    }
    
    private void dfs(int r, int c, int index, char[][] board, String word){
        if(r < 0 || r >= row || c < 0 || c >= col || find ||
        status[r][c] || word.charAt(index) != board[r][c])
            return;
        status[r][c] = true;
        if(index == word.length() - 1)
            find = true;
        dfs(r+1, c, index+1, board, word);
        dfs(r-1, c, index+1, board, word);
        dfs(r, c+1, index+1, board, word);
        dfs(r, c-1, index+1, board, word);
        status[r][c] = false;
    }
}