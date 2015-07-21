public class Solution {
    // O(n * 2^n) time:
    // isPalindrome O(n) * 解的个数
    //
    // 如何得到解的个数:
    // 举个栗子: s = "aaaa" (worst case)
    // 解空间树:
    //                             aaaa
    //             /                 \         \        \
    //            a                  aa        aaa     aaaa
    //       /    |    \            /  \        |
    //      a     aa   aaa         a   aa       a
    //     / \    /               /
    //    a  aa  a               a
    //   /
    //  a
    //          4(个)               2(个)       1(个)   1(个)
    // 8 in total, 解的个数:2^(n-1)
    // 
    // T(n) = T(n) + T(n-1) + T(n-2) + ... + T(1)
    //      = nT(1) + (n-1)T(1) + ... + T(1) = 2^(n-1)*T(1) = 2^(n-1)
    // 
    // 还是前面那个栗子:
    // T(4) = T(4) +                      T(3) +       T(2) + T(1) 
    //      = T(3) +        T(2) + T(1) + T(2) + T(1) +T(1) + T(1)
    //      = T(2) + T(1) + T(1) + T(1) + T(1) + T(1) +T(1) + T(1)
    //      = T(1) + T(1) + T(1) + T(1) + T(1) + T(1) +T(1) + T(1)
    //      = 8T(1) = 8

    // O(n) space:
    // one n is the recursion stack for longest path
    // another n is used for copy linked list
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<List<String>>();
        if(s == null || s.length() == 0)
            return ret;
        List<String> path = new LinkedList<String>();
        doDFS(0, s, path, ret);
        return ret;
    }
    
    private void doDFS(int start, String s, List<String> path, List<List<String>> ret){
        if(start == s.length()){
            List<String> sol = new LinkedList<String>(path);
            ret.add(sol);
            return;
        }
        
        for(int i = start + 1; i <= s.length(); i++){
            String cur = s.substring(start, i);
            if(isPalindrome(cur)){
                path.add(cur);
                doDFS(i, s, path, ret);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++; r--;
        }
        return true;
    }
}