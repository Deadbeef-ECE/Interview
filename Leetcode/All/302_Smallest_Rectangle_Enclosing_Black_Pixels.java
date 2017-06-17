public class Solution {
    // brute-force:
    // O(1) space, O(m*n) time
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0)  return 0;
        int xMax = Integer.MIN_VALUE, xMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE, yMin = Integer.MAX_VALUE;
        int row = image.length, col = image[0].length;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(image[i][j] == '1'){
                    xMax = Math.max(xMax, i);
                    xMin = Math.min(xMin, i);
                    yMax = Math.max(yMax, j);
                    yMin = Math.min(yMin, j);
                }
            }
        }
        return (xMax - xMin + 1) * (yMax - yMin + 1);
    }

    // DFS:
    // O(k) space, k is the number of pixels
    // O(b^d) time, k is the number of pixels
    int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
    int row, col;
    Set<Integer> visited;
    int xMax = Integer.MIN_VALUE, xMin = Integer.MAX_VALUE;
    int yMax = Integer.MIN_VALUE, yMin = Integer.MAX_VALUE;
    
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0)
            return 0;
        visited = new HashSet<Integer>();
        row = image.length;
        col = image[0].length;
        dfs(image, x, y);
        return (xMax - xMin + 1) * (yMax - yMin + 1);
    }
    
    private void dfs(char[][] image, int x, int y){
        if(x < 0 || y < 0 || x >= row || y >= col 
            || visited.contains(x * col + y) || image[x][y] == '0')
            return;
        xMax = Math.max(xMax, x);
        xMin = Math.min(xMin, x);
        yMax = Math.max(yMax, y);
        yMin = Math.min(yMin, y);
        visited.add(x * col + y);

        for(int i = 0; i < 8; i++){
            int r = x + dx[i];
            int c = y + dy[i];
            dfs(image, r, c);
        }
    }
}