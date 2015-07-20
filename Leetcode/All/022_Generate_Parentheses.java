public class Solution {
    // O(n)*h(n) time:
    // Explanation:
    // 此题时间复杂度应该是解的个数乘以每个解的长度, 解的个数对应卡特兰数h(n)的通项公式: 
    // h(n) = 2n!/(n!*n+1!) = C(2*n, n)/(n+1)
    // 解的长度是2n, 也就是O(n)

    // O(n) space:
    // path的最大长度也是recursion stack的最高高度, 为2n. 
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<String>();
        if(n == 0)  return ret;
        String path = "";
        doDFS(0, 0, n, path, ret);
        return ret;
    }
    
    private void doDFS(int left, int right, int n, String path, List<String> ret){
        if(right > left)    return;
        if(left == n && right == n){
            ret.add(path);
            return;
        }
        if(left == n){
            doDFS(left, right + 1, n, path + ")", ret);
            return;
        }
        doDFS(left + 1, right, n, path + "(", ret);
        doDFS(left, right + 1, n, path + ")", ret);
    }
}