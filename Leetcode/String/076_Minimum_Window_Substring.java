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
}