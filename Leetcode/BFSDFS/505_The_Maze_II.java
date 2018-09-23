class Solution {
    int m, n;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0)
            return -1;
        m = maze.length;
        n = maze[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            for(int k = 0; k < 4; k++){
                int x = i + dx[k], y = j + dy[k];
                int s = 1;
                while(x >= 0 && y >= 0 && x < m && y < n && maze[x][y] != 1){
                    x += dx[k];
                    y += dy[k];
                    s++;
                }
                s--;
                x -= dx[k];
                y -= dy[k];
                if(dist[i][j] + s < dist[x][y]){
                    dist[x][y] = dist[i][j] + s;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        int ret = dist[destination[0]][destination[1]];
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}