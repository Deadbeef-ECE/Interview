public class Solution {
    // O(n) space:
    // one n for status array, another n if consider recursion stack
    // 
    // How to get the best performance according to O(n) space? 
    // The answer is having a cache line which is larger than n.

    // O(n * n!) time:
    // At first glance, the time complexity maybe O(n * n^n).  We know that 
    // in each step, we need another O(n) time to check the status array.
    // Finally, we get O(n * n^n) running time.
    // 
    // 那么问题来了: Can we do better? Yes
    // 
    // T(n) = n * [T(n-1) + O(n)] 
    // divide by n! in each side: T(n)/n! = T(n-1)/n-1! + O(n)/n-1!
    // 
    // Then: T(n)/n! = O(n)/n-1! + O(n-1)/n-2! + O(n-2)/n-3! + ...
    //               = n/n-1! + n-1/n-2! + n-2/n-3! + ... + 2/1! + 1/0!
    //               = 1/(n-1!/n) + 1/(n-2!/n-1) +...
    //               < 1/n + 1/n +....   = n (while n > 5)
    // Finally, we know that T(n)/n! < n, which means T(n) = O(n * n!)
    //
    // Actually we can do much better to shrink the time complexity to
    // O(k * n!):
    // 数学归纳法, 假设T(n)/n! = k, 那么
    // T(n+1)/n+1! = n+1/n! + n/n-1! + n-2/n-3! + ... + 1/0!
    //             = n+1/n! + T(n)/n! = n+1/n! + k
    // 表面看起来貌似不成立, 但是我们知道当n->无穷大时候, n+1/n! ~ 0, 所以
    // T(n+1)/n+1! = T(n)/n! = k when n很大的时候
    // We get T(n) = O(k * n!) time complexity

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