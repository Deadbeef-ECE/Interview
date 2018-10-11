class Solution {
    int m, n;
    int[] right = {0, 1};
    int[] down = {1, 0};
    int[] diag = {1, 1};
    int[] anti = {1, -1};
    
    public int longestLine(int[][] M) {
        if(M == null || M.length == 0)
            return 0;
        m = M.length;
        n = M[0].length;
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(M[i][j] == 0)    continue;
                // we are in leftMost 1, explore left -> right
                if(j == 0 || M[i][j-1] == 0)
                    max = Math.max(max, explore(right, i, j, M));
                // we are in upperMost 1, explore top -> down
                if(i == 0 || M[i-1][j] == 0)
                    max = Math.max(max, explore(down, i, j, M));
                // we are in TopLeft 1, explore TopLeft -> BottomRight (diag)
                if(i == 0 || j == 0 || M[i-1][j-1] == 0)
                    max = Math.max(max, explore(diag, i, j, M));
                // we are in TopRight 1, explore TopRight -> BottomLeft (anti)
                if(i == 0 || j == n - 1 || M[i-1][j+1] == 0)
                    max = Math.max(max, explore(anti, i, j, M));
            }
        }
        return max;
    }
    
    private int explore(int[] dir, int i, int j, int[][] M){
        int len = 0;
        while(i >= 0 && j >= 0 && i < m && j < n && M[i][j] == 1){
            len++;
            i += dir[0];
            j += dir[1];
        }
        return len;
    }
}