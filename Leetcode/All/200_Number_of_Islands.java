public class Solution {
    // O(1) space without recursion stack
    // O(n) space with recursion stack, n is the maximum height of recursion tree
    // O(n^2 * avgLen) time: 
    // traversal every nodes, for each node, traversal numbers of average nodes of the 
    // path from it
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int ret = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    ret++;
                    doDFS(grid, i, j);
                }
            }
        }
        return ret;
    }
    
    private void doDFS(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        doDFS(grid, i+1, j);
        doDFS(grid, i-1, j);
        doDFS(grid, i, j+1);
        doDFS(grid, i, j-1);
    }
}