public class Solution {
    // ref: https://segmentfault.com/a/1190000003797204
    //O(n^2) time, O(n) space
    public List<String> addOperators(String num, int target) {
        List<String> ret = new LinkedList<String>();
        dfs(num, 0, 0, 0, target, "", ret);
        return ret;
    }
    
    public void dfs(String num, int index, long pre, long result, int target, String path, List<String> ret){
        if(index == num.length()){
            if(target == result) ret.add(path);
            return;
        }
        
        for(int i = index + 1; i <= num.length(); i++){
            String str = num.substring(index, i);
            long n = Long.parseLong(str);
            if(str.charAt(0) == '0' && i - index > 1)    
                return;
            if(index != 0){
                dfs(num, i, n, result + n, target, path + "+" + n, ret);
                dfs(num, i, -n, result - n, target, path + "-" + n, ret);
                dfs(num, i, n * pre, result - pre + pre * n, target, path + "*" + n, ret);
            }else{
                dfs(num, i, n, n, target, path + n, ret);
            }
        }
    }
}