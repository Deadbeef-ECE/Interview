/* 题意:
 * 给一个List<String> words, 里面的word是按照某种方式字典排序的, 找出排序的字母顺序
 * E.g.:
 * ["wrt", "wrf", "er", "ett","rftt"], The correct order is: "wertf".
 * 
 * solution:
 * Topological sort
 */

public class Solution {
    private Stack<Character> reverseOrder;
    private boolean hasCycle;
    public String alienOrder(String[] words) {
        reverseOrder = new Stack<Character>();
        hasCycle = false;
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        BuildGraph(words, map);
        String ret = findOrder(map);
        return ret;
    }
    
    private void BuildGraph(String[] words, HashMap<Character, Set<Character>> map){
        for(int i = 0; i < words.length; i++){
            String curWord = words[i];
            String nextWord = "";
            int cnt = 0;
            if(i != words.length-1)
                nextWord = words[i+1];
            for(int j = 0; j < curWord.length(); j++){
                if(!map.containsKey(curWord.charAt(j))){
                    Set<Character> set = new HashSet<Character>();
                    map.put(curWord.charAt(j), set);
                }
                if(cnt < 1 && j < nextWord.length() && curWord.charAt(j) != nextWord.charAt(j)){
                    map.get(curWord.charAt(j)).add(nextWord.charAt(j));
                    cnt++;
                }
            }
        }
    }
    
    private String findOrder(HashMap<Character, Set<Character>> map){
        int[] visited = new int[256];
        StringBuilder sb = new StringBuilder();
        for(char ch : map.keySet()){
            if(visited[ch] == 0)
                dfs(map, visited, ch);
        }
        if(hasCycle)    return "";
        while(!reverseOrder.isEmpty()){
            char cur = reverseOrder.pop();
            sb.append(cur);
        }
        return sb.toString();
    }
    
    private void dfs(HashMap<Character, Set<Character>> map, int[] visited, char c){
        visited[c] = -1;
        for(Character ch : map.get(c)){
            if(hasCycle)    return;
            if(visited[ch] == -1){
                hasCycle = true;
                return;
            }
            if(visited[ch] == 0)
                dfs(map, visited, ch);
        }
        reverseOrder.push(c);
        visited[c] = 1;
    }
}