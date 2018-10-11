class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return new int[]{};
        int m = matrix.length, n = matrix[0].length;
        int[] ret = new int[m * n];
        int d = 0, r = 0, c = 0;
        int[] dx = {-1, 1};
        int[] dy = {1, -1};
        for (int i = 0; i < m * n; i++) {
            ret[i] = matrix[r][c];
            r += dx[d];
            c += dy[d];
            
            if (r >= m) { r = m - 1; c += 2; d = 1 - d;}
            if (c >= n) { c = n - 1; r += 2; d = 1 - d;}
            if (r < 0)  { r = 0; d = 1 - d;}
            if (c < 0)  { c = 0; d = 1 - d;}
        }
        return ret;
    }
}