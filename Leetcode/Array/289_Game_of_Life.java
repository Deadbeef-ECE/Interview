public class Solution {
    int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    int row, col;
    HashMap<Integer, Integer> map;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0)
            return;
        row = board.length;
        col = board[0].length;
        map = new HashMap<Integer, Integer>();
        
        int[][] copy = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int state = getState(board, i, j);
                if(state != 0){
                    int serial = i * col + j;
                    map.put(serial, state);
                }
            }
        }
        
        for(int serial : map.keySet()){
            int i = serial / col;
            int j = serial % col;
            board[i][j] = map.get(serial) == 1 ? 0 : 1;
        }
        return;
    }
    // Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    // Any live cell with two or three live neighbors lives on to the next generation.
    // Any live cell with more than three live neighbors dies, as if by over-population..
    // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    
    // return -1, this cell should be die if orignially alive
    // return 0, this cell should be stay
    // return 1, this cell should be revive if originally dead
    private int getState(int[][] board, int i, int j){
        int cnt = 0;
        for(int k = 0; k < 8; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x < 0 || y < 0 || x >= row || y >= col)
                continue;
            if(board[x][y] == 1)
                cnt++;
        }
        
        int serial = i * col + j;
        if(board[i][j] == 0 && cnt == 3)
            return -1;
        if(board[i][j] == 1 && (cnt < 2 || cnt > 3))
            return 1;
        return 0;
    }
}