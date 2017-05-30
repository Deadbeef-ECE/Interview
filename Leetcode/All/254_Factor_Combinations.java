public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(n <= 3)  return ret;
        List<Integer> path = new LinkedList<Integer>();
        getFactors(2, n, path, ret);
        return ret;
    }
    
    private void getFactors(int start, int n, List<Integer> path, List<List<Integer>> ret){
       for(int i = start; i <= Math.sqrt(n); i++){
           if(n % i == 0 && n/i >= i){
               path.add(i);
               path.add(n/i);
               ret.add(new LinkedList<Integer>(path));
               path.remove(path.size() - 1);
               getFactors(i, n/i, path, ret);
               path.remove(path.size() - 1);
           }
       }
    }
}

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(n <= 3)  return ret;
        List<Integer> path = new LinkedList<Integer>();
        getFactors(2, n, path, ret);
        return ret;
    }
    
    private void getFactors(int start, int n, List<Integer> path, List<List<Integer>> ret){
        if(n == 1){
            if(path.size() == 1)    return;
            ret.add(new LinkedList<Integer>(path));
            return;
        }
        for(int i = start; i <= n; i++){
            if(n % i == 0){
                path.add(i);
                getFactors(i, n / i, path, ret);
                path.remove(path.size() - 1);
            }
        }
    }
}