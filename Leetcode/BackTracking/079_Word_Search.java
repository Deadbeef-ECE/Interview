public class Solution {
    // TODO: 
    // O() time
    // O() space
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(doDFS(i, j, board, 0, word, visited))
                    return true;
            }
        }
        return false;
    }
    
    private boolean doDFS(int i, int j, char[][] board, int pos, String word, boolean[][] visited){
        if(pos == word.length())    return true;
        int row = board.length;
        int col = board[0].length;
        if(i < 0 || j < 0 || i >= row || j >= col || board[i][j] != word.charAt(pos) || 
            visited[i][j] == true)
            return false;
        visited[i][j] = true;
        if(doDFS(i + 1, j, board, pos + 1, word, visited)) return true;
        if(doDFS(i, j + 1, board, pos + 1, word, visited)) return true;
        if(doDFS(i - 1, j, board, pos + 1, word, visited)) return true;
        if(doDFS(i, j - 1, board, pos + 1, word, visited)) return true;
        visited[i][j] = false;
        return false;
    }
}