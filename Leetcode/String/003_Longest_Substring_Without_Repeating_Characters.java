public class Solution {
    // O(1) space, O(n) time
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1)
            return 0;
        int start = 0;
        int cur = 0;
        int max = 0;
        int[] table = new int[256];
        Arrays.fill(table, -1);
        while(cur < s.length()){
            int ch = s.charAt(cur);
            if(table[ch] >= start)
                start = table[ch]+1;
            max = Math.max(max, cur-start+1);
            table[ch] = cur;
            cur++;
        }
        return max;
    }
    // sliding window模板解法
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, dist = 0;
        int start = 0, end = 0;
        
        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > 1)  count++;
            end++;
            while(count > 0){
                char a = s.charAt(start);
                if(map.get(a) > 1)  count--;
                map.put(a, map.get(a) - 1);
                start++;
            }
            dist = Math.max(dist, end - start);
        }
        return dist;
    }
}