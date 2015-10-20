public class Solution {
    HashMap<Character, String> map = new HashMap<Character, String>();
    Set<String> set = new HashSet<String>();
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.length() == 0)   
            return str.length() == 0;
            
        if(map.containsKey(pattern.charAt(0))){
            String part = map.get(pattern.charAt(0));
            if(str.length() < part.length() || !part.equals(str.substring(0, part.length())))
                return false;
            if(wordPatternMatch(pattern.substring(1), str.substring(part.length())))
                return true;
        }else{
            for(int i = 1; i <= str.length(); i++){
                String part = str.substring(0, i);
                if(set.contains(part))  continue;
                map.put(pattern.charAt(0), part);
                set.add(part);
                if(wordPatternMatch(pattern.substring(1), str.substring(i)))
                    return true;
                set.remove(str.substring(0,i));
                map.remove(pattern.charAt(0));
            }
        }
        return false;
    }
}