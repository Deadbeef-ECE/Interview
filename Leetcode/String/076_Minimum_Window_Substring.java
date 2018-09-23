public class Solution {
    // O(1) space, O(n) time
    public String minWindow(String s, String t) {
        if(t == null || t.length() == 0)
            return t;
        int[] need = new int[256];
        int[] has = new int[256];
        for(int i = 0; i < t.length(); i++)
            need[t.charAt(i)]++;
        
        int start = 0, end = 0, cnt = 0;
        int min = Integer.MAX_VALUE;
        String ret = "";
        for(end = 0; end < s.length(); end++){
            if(need[s.charAt(end)] == 0)    continue;
            char c = s.charAt(end);
            has[c]++;
            if(has[c] <= need[c])
                cnt++;
            // shrink the window
            if(cnt == t.length()){
                while(need[s.charAt(start)] == 0 || 
                    need[s.charAt(start)] < has[s.charAt(start)]){
                    if(need[s.charAt(start)] < has[s.charAt(start)])
                        has[s.charAt(start)]--;
                    start++;
                }
                if(end - start + 1 < min){
                    min = end - start + 1;
                    ret = s.substring(start, end+1);
                }
            }
        }
        return ret;
    }

    // 模板解法
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
        }
        
        int count = map.size();
        int start = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0)
                    count--;
            }
            end++;
            while(count == 0){
                char a = s.charAt(start);
                if(map.containsKey(a)){
                    map.put(a, map.get(a) + 1);
                    if(map.get(a) > 0)
                        count++;
                }
                if(end - start < len){
                    len = end - start;
                    head = start;
                }
                start++;
            }
        }
        if(len == Integer.MAX_VALUE)    return "";
        return s.substring(head, head + len);
    }
}