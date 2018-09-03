class Solution {
    // Two map solution:
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new LinkedList<>();
        for(String str : words){
            if(match(str, pattern))
                ret.add(str);
        }
        return ret;
    }
    
    private boolean match(String str, String pattern){
        if(str.length() != pattern.length())    return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        
        for(int i = 0; i < str.length(); i++){
            char a = str.charAt(i);
            char b = pattern.charAt(i);
            if(!map1.containsKey(a))    map1.put(a, b);
            if(!map2.containsKey(b))    map2.put(b, a);
            if(map1.get(a) != b || map2.get(b) != a)
                return false;
        }
        return true;
    }

    // One map solution:
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new LinkedList<>();
        for(String str : words){
            if(match(str, pattern))
                ret.add(str);
        }
        return ret;
    }
    
    private boolean match(String str, String pattern){
        if(str.length() != pattern.length())    return false;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char a = str.charAt(i);
            char b = pattern.charAt(i);
            if(!map.containsKey(a)) map.put(a, b);
            if(map.get(a) != b) return false;
        }
        
        // check duplicate value
        // a->c, b->c => not 1:1 mapping
        boolean[] seen = new boolean[26];
        for (char p: map.values()) {
            if (seen[p - 'a']) return false;
            seen[p - 'a'] = true;
        }
        return true;
    }
}