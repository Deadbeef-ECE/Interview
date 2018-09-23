class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length)
            return false;
        Map<String, Set<String>> map = new HashMap<>();
        for(String[] s : pairs){
            if(!map.containsKey(s[0]))
                map.put(s[0], new HashSet<>());
            if(!map.containsKey(s[1]))
                map.put(s[1], new HashSet<>());
            map.get(s[0]).add(s[1]);
            map.get(s[1]).add(s[0]);
        }
        
        for(int i = 0; i < words1.length; i++){
            String s1 = words1[i], s2 = words2[i];
            if(s1.equals(s2))
                continue;
            if(!map.containsKey(s1))
                return false;
            if(!map.get(s1).contains(s2))
                return false;
        }
        
        return true;
    }
}