public class Solution {
    public int minTotalDistance(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int r = grid.length;
        int c = grid[0].length;
        List<Integer> row = new LinkedList<Integer>();
        List<Integer> col = new LinkedList<Integer>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        int sum = 0;
        int mid = row.get(row.size() / 2);
        for(int i : row)    sum += Math.abs(mid - i);
        Collections.sort(col);
        mid = col.get(col.size() / 2);
        for(int j : col)    sum += Math.abs(mid - j);
        return sum;
    }
}