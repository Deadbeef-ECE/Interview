public class Solution {
    int[] X = {1, -1, 0, 0};
    int[] Y = {0, 0, 1, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] mem = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, mem);
                max = Math.max(max, len);
            }
        }   
        return max;
    }
    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] mem) {
        if(mem[i][j] != 0)  return mem[i][j];
        int max = 1;
        for(int k = 0; k < 4; k++){
            int x = i + X[k], y = j + Y[k];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j])
                continue;
            int len = 1 + dfs(matrix, x, y, m, n, mem);
            max = Math.max(max, len);
        }
        mem[i][j] = max;
        return max;
    }
}