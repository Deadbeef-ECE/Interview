public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k < 1)  return k;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0, max = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c))
                map.put(c, 0);
            else
                map.put(c, map.get(c) + 1);
            
            while(map.size() > k){
                char t = s.charAt(start);
                int cnt = map.get(t);
                if(cnt > 0) map.put(t, cnt - 1);
                else map.remove(t);
                start++;
            }
            max = Math.max(i - start + 1, max);
        }
        return max;
    }
}