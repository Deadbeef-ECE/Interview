public class Solution {
    // Math:
    // O(n^2) time, O(1) space
    public String getPermutation(int n, int k) {
        if(n == 0){
            return "";
        }
        List<Integer> numbers = new LinkedList<Integer>();
        int totalPerm = 1;
        //Compute n! and store each unique number in the arraylist 
        //in the form {1, 2, 3, 4,...,n-1, n}
        for(int i = 1; i <= n; i++){
            totalPerm *= i; //1*2*3*..*n
            numbers.add(i);
        }
        if(k > totalPerm)
            return "";
        //get the (n-1)! by n!/n
        int inner = totalPerm/n;
        //start from 0
        k--;
        //build the string to store the digit
        StringBuilder ret = new StringBuilder();
        //has n in total
        for(int i = n - 1; i >= 1; i--){
            //get the index of number
            int indexOfNum = k/inner;
            //get the number according to the index
            int num = numbers.get(indexOfNum);
            //put the number to the string and remove from the list
            ret.append(String.valueOf(num));
            numbers.remove(indexOfNum);
            //get the remainder of k%inner(k-(n-1)!) to check the (n-2)! of (n-1)!
            k = k%inner;
            //get the (n-2)! from (n-1)!/(n-1)
            inner = inner/i;
        }
        ret.append(String.valueOf(numbers.get(0)));
        return ret.toString();
    }

    // DFS + prune 爆搜, 大数据超时
    public static String getPermutation(int n, int k) {
        List<String> ret = new LinkedList<String>();
        StringBuilder path = new StringBuilder();
        boolean[] status = new boolean[n+1];
        boolean[] found = new boolean[1];
        int[] times = {0};
        found[0] = false;
        doDFS(1, n, k, status, path, ret, found, times);
        return ret.get(0);
    }
    
    private static void doDFS(int start, int end, int k, boolean[] status,
    StringBuilder path, List<String> ret, boolean[] found, int[] times)
    {
        if(path.length() == end && times[0] < k){
            times[0]++;
            if(times[0] == k){
                ret.add(path.toString());
                found[0] = true;
            }
            return;
        }
        
        for(int i = 1; i <= end; i++){
            if(found[0] == false && status[i] == false){
                status[i] = true;
                path.append(i);
                doDFS(i+1, end, k, status, path, ret, found, times);
                path.deleteCharAt(path.length()-1);
                status[i] = false;
            }
        }
    }
}