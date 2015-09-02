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
    public static List<String> generatePalindromes(String s) {
        List<String> ret = new LinkedList<String>();
        if(s == null || s.length() == 0)    return ret;
        int[] table = new int[256];
        int cnt = 0;
        for(int i = 0; i < s.length(); i++)
            table[s.charAt(i)]++;
        
        char single = ' ';
        StringBuilder half = new StringBuilder();
        for(int i = 0; i < 256; i++){
            if(table[i] % 2 == 1){
                cnt++;
                single = (char)i;
                table[i]--;  // aaa这种情况 要删除一个
            }
            if (table[i] > 0){
                while(table[i] > 0){
                    half.append((char)i);
                    table[i] -= 2;
                }
            }
        }
        // cnt > 1 说明奇数字符超过一个, 无解
        if(cnt > 1) return ret;
        doPerm(half, single, ret);
        return ret;
    }
    
    private static void doPerm(StringBuilder s, char single, List<String> ret){
        Set<String> set = new HashSet<String>();
        boolean[] visited = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        doDFS(s, single, visited, sb, set, ret);
    }
    
    private static void doDFS(StringBuilder s, char single, boolean[] visited, 
                        StringBuilder path, Set<String> set, List<String> ret){

        if(path.length() == s.length() && !set.contains(path.toString())){
        	StringBuilder sol = new StringBuilder(path);
        	set.add(sol.toString());
            int i = sol.length() - 1;
            if(single != ' ')
            	sol.append(single);
    
            String rest = "";
            for(; i >= 0; i--)
                rest += sol.charAt(i);
            String all = sol.toString() + rest;
            ret.add(all);
            return;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(visited[i] == false){
                visited[i] = true;
                path.append(s.charAt(i));
                doDFS(s, single, visited, path, set, ret);
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
    }
}