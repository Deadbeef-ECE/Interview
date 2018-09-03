public class Solution {
    // O(n)*h(n) time:
    // Explanation:
    // 此题时间复杂度应该是解的个数乘以每个解的长度, 解的个数对应卡特兰数h(n)的通项公式: 
    // h(n) = 2n!/(n!*n+1!) = C(2*n, n)/(n+1)
    // 解的长度是2n, 也就是O(n)

    // O(n) space:
    // path的最大长度也是recursion stack的最高高度, 为2n. 
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        dfs("", n, 0, 0, list);
        return list;
    }
    
    private void dfs(String s, int n, int left, int right, List<String> list){
        if(right > left)    return;
        if(left > n || right > n)    return;
        if(left == right && left == n)
            list.add(s);
        dfs(s + "(", n, left + 1, right, list);
        dfs(s + ")", n, left, right + 1, list);
    }

    // Iteration:
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<String>();        
        if(n < 1)   return ret;
        //记录左括号和右括号的差值
        List<Integer> cnt = new LinkedList<Integer>();

        ret.add("(");
        cnt.add(1);

        for(int i = 1; i < 2 * n; i++){
            int size = ret.size();
            for(int k = 0; k < size; k++){
                String tmp = ret.remove(0);
                int count = cnt.remove(0);
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