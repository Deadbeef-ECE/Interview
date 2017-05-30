public class ValidWordAbbr {
    private HashMap<String, Set<String>> map;
    // O(n) space, O(1) time
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, Set<String>>();
        for(String str : dictionary){
            String abrStr = compress(str); 
            if(!map.containsKey(abrStr)){
                Set<String> set = new HashSet<String>();
                map.put(abrStr, set);
            }
            map.get(abrStr).add(str);
        }
    }
    
    // O(1) space, O(1) time
    private String compress(String str){
        if(str.length() < 3)    return str;
        String ret = str.charAt(0) + String.valueOf(str.length() -2) + str.charAt(str.length() - 1);
        return ret;
    } 

    // O(n) space, O(1) time
    public boolean isUnique(String word) {
        String str = compress(word);
        if(!map.containsKey(str) || (map.get(str).contains(word) && map.get(str).size() == 1))
            return true;
        return false;
    }
}