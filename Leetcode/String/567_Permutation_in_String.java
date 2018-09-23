class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0;
        int count = map.size();
        
        while(end < s2.length()){
            char a = s2.charAt(end);
            if(map.containsKey(a)){
                map.put(a, map.get(a) - 1);
                if(map.get(a) == 0)
                    count--;
            }
            end++;
            while(count == 0){
                char b = s2.charAt(start);
                if(map.containsKey(b)){
                    map.put(b, map.get(b) + 1);
                    if(map.get(b) > 0)
                        count++;
                }
                if(end - start == s1.length())
                    return true;
                start++;
            }
        }
        return false;
    }
}