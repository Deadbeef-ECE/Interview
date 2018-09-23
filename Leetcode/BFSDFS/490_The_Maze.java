// DFS
class Solution {
    int m, n;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)
            return false;
        int i = start[0], j = start[1];
        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(i, j , maze, visited, destination);
    }
    
    private boolean dfs(int i, int j, int[][] maze, boolean[][] visited, int[] destination){
        if(i < 0 || j < 0|| i >= m || j >= n || visited[i][j] || maze[i][j] == 1)
            return false;
        if(i == destination[0] && j == destination[1])
            return true;
        visited[i][j] = true;
        for(int k = 0; k < 4; k++){
            int x = i + dx[k], y = j + dy[k];
            while(x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0){
                x += dx[k];
                y += dy[k];
            }
            x -= dx[k];
            y -= dy[k];
            if(dfs(x, y, maze, visited, destination))
                return true;
        }
        return false;
    }
}
// BFS
class Solution {
    int m, n;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)
            return false;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        m = maze.length;
        n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            for(int k = 0; k < 4; k++){
                int x = i + dx[k], y = j + dy[k];
                while(x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0){
                    x += dx[k];
                    y += dy[k];
                }
                x -= dx[k];
                y -= dy[k];
                if(x == destination[0] && y == destination[1])
                    return true;
                if(!visited[x][y]){
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return false;
    }
}