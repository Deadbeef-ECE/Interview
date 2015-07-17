public class Solution {
    // O(n) space:
    // one n for status array, another n if consider recursion stack)
    // O(n * n!) time:
    // This is an enumeration problem, so, basically, time complexity is O(n!), 
    // but in each step, we need another O(n) time to check the status array.
    // Finally, we get O(n * n!) running time.
    //
    // Another thing is that this kind of quesion usually run into TLE error
    // rather than SMO(Stack Memeory Overflow) error
    public int totalNQueens(int n) {
        if(n <= 1)  return n;
        int[] ret = {0};
        int[] status = new int[n];
        doDFS(0, n, status, ret);
        return ret[0];
    }
    
    private void doDFS(int row, int n, int[] status, int[] ret){
        if(row == n){
            ret[0]++;
            return;
        }
        
        for(int j = 0; j < n; j++){
            status[row] = j;
            if(isValid(status, row))
                doDFS(row + 1, n, status, ret);
        }
    }
    
    private boolean isValid(int[] status, int row){
        for(int i = 0; i < row; i++){
            if(status[i] == status[row] || 
                row - i == Math.abs(status[i] - status[row]))
                return false;
        }
        return true;
    }
}