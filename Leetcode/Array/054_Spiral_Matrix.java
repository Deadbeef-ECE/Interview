public class Solution {
    // O(m*n) space, O(m*n) time
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return ret;
        
        int top = 0, left = 0;
        int bottom = matrix.length - 1; 
        int right = matrix[0].length - 1;
        
        while(top <= bottom && left <= right){
            int i, j;
            for(j = left; j <= right; j++)
                ret.add(matrix[top][j]);
                
            for(i = top+1; i <= bottom; i++)
                ret.add(matrix[i][right]);
            
            if(top < bottom){
                for(j = right - 1; j >= left; j--)
                    ret.add(matrix[bottom][j]);
            }      
            if(left < right){
                for(i = bottom - 1; i >= top+1; i--)
                    ret.add(matrix[i][left]);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return ret;
    }
}