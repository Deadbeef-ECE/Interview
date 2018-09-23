// BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        int m = image.length, n = image[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sr * n + sc);
        int oldColor = image[sr][sc];
        while(!queue.isEmpty()){
            int idx = queue.poll();
            int r = idx / n, c = idx % n;
            image[r][c] = newColor;
            for(int k = 0; k < 4; k++){
                int x = r + dx[k], y = c + dy[k];
                if(x < 0 || y < 0 || x >= m || y >= n || image[x][y] != oldColor)
                    continue;
                queue.add(x * n + y);
            }
        }
        return image;
    }
}
// DFS
class Solution {
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        m = image.length;
        n = image[0].length;
        dfs(sr, sc, image, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int i, int j, int[][] image, int oldColor, int newColor){
        if(i < 0 || j < 0 || i >= m || j >= n || image[i][j] != oldColor)
            return;
        image[i][j] = newColor;
        dfs(i + 1, j, image, oldColor, newColor);
        dfs(i - 1, j, image, oldColor, newColor);
        dfs(i, j + 1, image, oldColor, newColor);
        dfs(i, j - 1, image, oldColor, newColor);
    }
}