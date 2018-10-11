class TicTacToe {
    int[][] board;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int N) {
        board = new int[N][N];
        n = N;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(board[i][col] == player)
                cnt++;
        }
        if(cnt == n)
            return player;

        cnt = 0;
        for(int j = 0; j < n; j++){
            if(board[row][j] == player)
               cnt++;
        }
        if(cnt == n)
            return player;
        
        if(row == col){
            cnt = 0;
            for(int i = 0; i < n; i++){
                if(board[i][i] == player)
                    cnt++;
            }
            if(cnt == n)
                return player;
        }
        
        if(row + col == n -1){
            cnt = 0;
            for(int i = 0; i < n; i++){
                if(board[i][n - 1 - i] == player)
                    cnt++;
            }
            if(cnt == n)
                return player;
        }
    
        return 0;
    }
}

// O(n)

class TicTacToe {
    int[] r;
    int[] c;
    int diag;
    int antiDiag;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int N) {
        r = new int[N];
        c = new int[N];
        diag = antiDiag = 0;
        n = N;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        
        r[row] += add;
        c[col] += add;
        
        if(row == col)
            diag += add;
        if(col ==n - 1 - row)
            antiDiag += add;
        if(Math.abs(r[row]) == n || Math.abs(c[col]) == n
           || Math.abs(diag) == n || Math.abs(antiDiag) == n)
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */