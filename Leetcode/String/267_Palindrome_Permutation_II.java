/* 题意:
 * 给一个String s, 返回所有的Palindrome. 没有则返回空
 * E.g.:
 * Given s = "aabb", return ["abba", “baab”];   
 * Given s = "abc", return []. 
 *
 * solution: 
 * 先生成半边的permutation, 再组合
 */

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> ret = new LinkedList<String>();
        if(s == null || s.length() == 0)    return ret;
        HashSet<Character> set = new HashSet<Character>();
        int[] table = new int[256];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c))
                set.remove(c);
            else
                set.add(c);
            table[c]++;
        }
        if(set.size() > 1)  return ret;
        char sp = '*';
        
        for(int i = 0; i < 256; i++){
            if(table[i] % 2 == 1)
                sp = (char)(i);
            table[i] /= 2;
        }

        int size = s.length()/2;
        dfs(table, "", sp, size, ret);
        return ret;
    }
    
    public void dfs(int[] table, String half, char sp, int size , List<String> ret){
        if(half.length() == size){
            String whole = half + (sp != '*' ? sp : "") +  new StringBuilder(half).reverse().toString();
            if(!ret.contains(whole))    ret.add(whole);
            return;
        }
        
        for(int i = 0; i < 256; i++){
            if(table[i] > 0){
                String temp = half;
                half = half + (char)(i);
                table[i]--;
                dfs(table, half, sp, size, ret);
                table[i]++;
                half = temp;
            }
        }
    }
}