class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length < 3)
            return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> (a.h - b.h));
        for(int i = 0; i < m; i++){
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.add(new Cell(i, 0, heightMap[i][0]));
            pq.add(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        
        for(int j = 0; j < n; j++){
            visited[0][j] = true;
            visited[m - 1][j] = true;
            pq.add(new Cell(0, j, heightMap[0][j]));
            pq.add(new Cell(m - 1, j, heightMap[m - 1][j]));
        }
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        int water = 0;
        while(!pq.isEmpty()){
            Cell cur = pq.poll();
            for(int i = 0; i < 4; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];
                if(x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]){
                    visited[x][y] = true;
                    water += Math.max(0, cur.h - heightMap[x][y]);
                    pq.add(new Cell(x, y, Math.max(cur.h, heightMap[x][y])));
                }
            }
        }
        return water;
    }
}

class Cell{
    int x;
    int y;
    int h;
    public Cell(int i, int j, int height){
        this.x = i;
        this.y = j;
        this.h = height;
    }
}