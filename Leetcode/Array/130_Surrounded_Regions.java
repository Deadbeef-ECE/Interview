public class Solution {
    // DFS(TLE) 
    public void solve(char[][] board) {
        if(board == null || board.length == 0)  return;
        int row = board.length;
        int col = board[0].length;
        if (row == 1 || col == 1)   return;
        
        for(int j = 0; j < col; j++){
            doDFS(board, 0, j);
            doDFS(board, row-1, j);
        }
        
        for(int i = 1; i < row-1; i++){
            doDFS(board, i, 0);
            doDFS(board, i, col-1);
        }
        for(int i = 0;i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j]=='#') 
                    board[i][j]='O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        return;
    }
    
    private void doDFS(char[][] board, int x, int y){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O'
        || board[x][y] == '#')
            return;
        board[x][y] = '#';
        doDFS(board, x-1, y);
        doDFS(board, x+1, y);
        doDFS(board, x, y-1);
        doDFS(board, x, y+1);
    }

    // BFS
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)  return;
        int row = board.length;
        int col = board[0].length;
        if (row == 1 || col == 1)   return;
        
        for(int j = 0; j < col; j++){
            doBFS(board, 0, j);
            doBFS(board, row-1, j);
        }
        
        for(int i = 1; i < row-1; i++){
            doBFS(board, i, 0);
            doBFS(board, i, col-1);
        }
        for(int i = 0;i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j]=='#') 
                    board[i][j]='O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        return;
    }
    private void doBFS(char[][] board, int x, int y){
        Queue<Integer> queue = new LinkedList<Integer>();
        int row = board.length;
        int col = board[0].length;
        queue.add(x * board[0].length + y);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if (cur < 0 || cur >= row * col)
                continue;
            int i = cur / col;
            int j = cur % col;
            if (board[i][j] != 'O')
                continue;

            board[i][j] = '#';
            queue.add(cur+1);
            queue.add(cur-1);
            queue.add(cur+col);
            queue.add(cur-col);
        }
    }
}