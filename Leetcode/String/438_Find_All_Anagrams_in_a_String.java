class Solution {
    // brute-force
    // O(n) space - substring();
    // O(mn) time - m, s.length(), n, p.length()
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        int len = p.length();
        for(int i = 0; i < s.length() - len + 1; i++){
            String sub = s.substring(i, i + len);
            if(isAnagram(sub, p))
                list.add(i);
        }
        return list;
    }

    private boolean isAnagram(String s, String p){
        int[] table = new int[26];
        for(int i = 0; i < s.length(); i++){
            table[s.charAt(i) - 'a']++;
            table[p.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(table[i] != 0)
                return false;
        }
        return true;
    }

    // 076 sliding window模板解题
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int start = 0, end = 0;
        int count = map.size();
        
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
                if(end - start == p.length())
                    list.add(start);
                start++;
            }
        }
        return list;
    }
}


