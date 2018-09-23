class Solution {
    int[][] numReach;
    int[][] dist;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};
    int row, col;

    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        row = grid.length;
        col = grid[0].length;
        // When gird[i][j] == 0, how many building can reach from [i, j]
        numReach = new int[row][col];
        // When gird[i][j] == 0, what is the dist from all the building it can reach
        dist = new int[row][col];
        int buildingNum = 0;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    bfs(grid, i, j);
                    buildingNum++;
                }
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0 && numReach[i][j] == buildingNum && dist[i][j] < minDist)
                    minDist = dist[i][j];
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    
    private void bfs(int[][] grid, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        boolean[][] visited = new boolean[row][col];
        visited[i][j] = true;
        int distance = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int m = 0; m < size; m++){
                int[] cur = q.poll();
                for(int k = 0; k < 4; k++){
                    int x = cur[0] + dx[k];
                    int y = cur[1] + dy[k];
                    if(x >= 0 && y >= 0 && x < row && y < col && visited[x][y] == false && grid[x][y] == 0){
                        q.offer(new int[]{x, y});
                        visited[x][y] = true;
                        dist[x][y] += distance;
                        numReach[x][y]++;
                    }
                }
            }
            distance++;
        }
        
    }
}