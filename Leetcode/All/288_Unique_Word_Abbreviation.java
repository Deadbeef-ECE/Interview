public class ValidWordAbbr {

    private HashMap<String, List<String>> map;
    
    // O(n) space, O(n) time;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, List<String>>();
        for(String str : dictionary){
            String abrStr = compress(str); 
            if(!map.containsKey(abrStr)){
                List<String> list = new LinkedList<String>();
                map.put(abrStr, list);
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

    // O(n) space, O(1) time;
    public boolean isUnique(String word) {
        String str = compress(word);
        if(!map.containsKey(str) || (map.get(str).get(0).equals(word) && map.get(str).size() == 1))
            return true;
        return false;
    }
}
