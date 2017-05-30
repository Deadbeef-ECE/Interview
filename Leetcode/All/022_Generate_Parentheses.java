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

    // Iteration:
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<String>();
        //记录左括号和右括号的差值
        List<Integer> cnt = new LinkedList<Integer>();
        if(n < 1)   return ret;
        int l = 1, r = 0;
        ret.add("(");
        cnt.add(1);

        for(int i = 1; i < 2 * n; i++){
            int size = ret.size();
            for(int k = 0; k < size; k++){
                String tmp = ret.remove(0);
                Integer count = cnt.remove(0);
                // “()(((" tmp.length()  = 5, 
                // num of ( = a, num of ) = b;
                // a + b = tmp.length(), a - b = count;
                // a = (a + b + a - b) / 2 = (tmp.length() + count) / 2;
                if((tmp.length() + count)/2 < n){
                    ret.add(tmp + "(");
                    cnt.add(count + 1);
                }
                // a - b > 0就可以增加 ")"
                if(count > 0){
                    ret.add(tmp + ")");
                    cnt.add(count - 1);
                }
            }
        }
        return ret;
    }
}