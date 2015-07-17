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
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new LinkedList<List<String>>();
        int[] status = new int[n];
        doDFS(0, n, status, ret);
        return ret;
    }
    
    private void doDFS(int row, int n, int[] status, List<List<String>> ret){
        // build up board, add to ret and return;
        if(row == n){
            List<String> sol = new LinkedList<String>();
            for(int i = 0; i < n; i++){
                String oneRow = "";
                for(int j = 0; j < n; j++){
                    if(status[i] == j)
                        oneRow += "Q";
                    else
                        oneRow += ".";  
                }
                sol.add(oneRow);
            }
            ret.add(sol);
            return;
        }
        //第row行第j列放棋子儿
        for(int j = 0; j < n; j++){
            status[row] = j;
            if(isValid(status, row)){
                doDFS(row + 1, n, status, ret);
            }
        }
    }
    
    private boolean isValid(int[] status, int row){
        for(int i = 0; i < row; i++){
            if(status[i] == status[row] || 
                Math.abs(i - row) == Math.abs(status[i] - status[row]))
                return false;
        }
        return true;
    }
}