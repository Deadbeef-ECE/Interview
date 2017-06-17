public class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int row = grid.length, col = grid[0].length;
        
        int count = 0, neighbor = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    count++;
                    if(i < row - 1 && grid[i + 1][j] == 1)    neighbor++;
                    if(j < col - 1 && grid[i][j + 1] == 1)    neighbor++;
                }
            }
        }
        return count*4 - neighbor*2;
    }
}