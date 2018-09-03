public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n-1][n-1];
        if(n == 1)  return l;

        while(l <= r){
            int mid = l + (r - l) / 2;  
            int i = 0, j = n - 1;
            int count = 0;
            while(i < n && j >= 0){
                if(matrix[i][j] > mid){
                    j--;
                }else{
                    count += j + 1;
                    i++;
                }
            }
            if(count < k)   l = mid + 1;
            else    r = mid - 1;
            
        }
        return l;
    }
}