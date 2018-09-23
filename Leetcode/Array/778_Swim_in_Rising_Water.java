// DFS bruteforce
class Solution {
    int n;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int swimInWater(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        n = grid.length;
        Set<Integer> visited = new HashSet<>();
        int time = 0;
        while(!visited.contains(n * n - 1)){
            visited.clear();
            dfs(0, 0, visited, grid, time);
            time++;
        }
        return time - 1;
    }
    
    private void dfs(int i, int j, Set<Integer> visited, int[][] grid, int time){
        if(i < 0 || j < 0 || i >= n || j >= n || grid[i][j] > time)
            return;
        int idx = i * n + j;
        if(visited.contains(idx))   return;
        visited.add(idx);
        for(int k = 0; k < 4; k++){
            int x = i + dx[k], y = j + dy[k];
            dfs(x, y, visited, grid, time);
        }
    }
}

// DFS + BinarySearch(278. First Bad Version)
class Solution {
    int n;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int swimInWater(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        n = grid.length;
        Set<Integer> visited = new HashSet<>();
        int l = grid[0][0], r = n * n - 1;
        int last = 0;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(canVisit(grid, m)){
                r = m - 1;
                last = m;
            }else{
                l = m + 1;
            }
        }
        return last;
    }
    
    private boolean canVisit(int[][] grid , int h)
    {
        boolean[][] visit = new boolean[n][n];
        return dfs(0, 0, visit, grid, h);
    }
    private boolean dfs(int i, int j, boolean[][] visited, int[][] grid, int time){
        if(i < 0 || j < 0 || i >= n || j >= n || grid[i][j] > time || visited[i][j])
            return false;
        visited[i][j] = true;
        if(i == n - 1 && j == n - 1)    return true;
        for(int k = 0; k < 4; k++){
            int x = i + dx[k], y = j + dy[k];
            if(dfs(x, y, visited, grid, time))
                return true;
        }
        return false;
    }
}