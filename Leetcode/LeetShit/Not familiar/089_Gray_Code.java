public class Solution {
    //   n = 0       0
    //              ---
    //   n = 1       1
    //            -----
    //   n = 2     1 1
    //             1 0
    //          -------
    //   n = 3   1 1 0
    //           1 1 1
    //           1 0 1
    //           1 0 0

    // DFS recursion:
    // O(2^n) time, O(1) space OR O(n) space if consider recursion stack
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new LinkedList<Integer>();
        if(n < 0)   return ret;
        doDFS(n, ret);
        return ret;
    }
    
    private void doDFS(int n, List<Integer> ret){
        if(n == 0){
            ret.add(0);
            return;
        }
        
        doDFS(n - 1, ret);
        
        int add = 1 << (n - 1);
        for(int i = ret.size() - 1; i >= 0; i--)
            ret.add(ret.get(i) + add);
        return;
    }

    // Iteration:
    // O(2^n) time, O(1) space
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new LinkedList<Integer>();
        if(n < 0)   return ret;
        ret.add(0);
        for(int i = 0; i < n; i++){
            int high = 1 << i;
            for(int j = ret.size() - 1; j >= 0; j--){
                ret.add(high + ret.get(j));
            }
        }
        return ret;
    }

    // Math:
    // O(1) time, O(1) space
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new LinkedList<Integer>();
        int size = 1 << n;
        for(int i = 0; i < size; i++)
            ret.add((i >> 1)^i);
        return ret;
    }
}