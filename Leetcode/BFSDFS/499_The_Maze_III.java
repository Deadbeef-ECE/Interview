class Solution {
    int m, n;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    char[] direction = {'r', 'l', 'd', 'u'};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if(maze == null || maze.length == 0)
            return "impossible";
        m = maze.length;
        n = maze[0].length;
        Cell[][] cell = new Cell[m][n];
        cell[ball[0]][ball[1]] = new Cell();
        cell[ball[0]][ball[1]].dist = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(ball);
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            for(int k = 0; k < 4; k++){
                char d = direction[k];
                int x = i + dx[k], y = j + dy[k];
                int s = 1;
                while(x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0 && (x != hole[0] || y != hole[1])){
                    x += dx[k];
                    y += dy[k];
                    s++;
                }
                if(x != hole[0] || y != hole[1]){
                    s--;
                    x -= dx[k];
                    y -= dy[k];
                }
                
                if(cell[x][y] == null)
                   cell[x][y] = new Cell();
                String path = cell[i][j].dir + d;
                if(cell[i][j].dist + s < cell[x][y].dist){
                    cell[x][y].dist = cell[i][j].dist + s;
                    cell[x][y].dir = path;
                    if(x != hole[0] || y != hole[1])
                        queue.offer(new int[]{x, y});
                }else if(cell[i][j].dist + s == cell[x][y].dist && cell[x][y].dir.compareTo(path) > 0){
                    cell[x][y].dir = path;
                    if(x != hole[0] || y != hole[1])
                        queue.offer(new int[]{x, y});
                }
            }
        }
        
        if(cell[hole[0]][hole[1]] == null)
            return "impossible";
        return cell[hole[0]][hole[1]].dir;
    }
}

class Cell{
    int dist;
    String dir;
    public Cell(){
        this.dist = Integer.MAX_VALUE;
        this.dir = "";
    }
}