public class Solution {
    // O(1) space, O(logn)(n = row * col) time
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int lo = 0;
        int hi = row * col - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int x = mid / col;
            int y = mid % col;
            if(target == matrix[x][y])
                return true;
            if(target > matrix[x][y])
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }
}