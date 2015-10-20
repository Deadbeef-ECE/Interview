public class Solution {
    // Use HashMap to prune
    public boolean canWin(String s) {
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        if(s == null || s.length() < 2) return false;
        return canWin(s, map);
    }
    
    private boolean canWin(String s, HashMap<String, Boolean> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)){
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if(!canWin(t, map)){
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    // Brute-force:
    public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)){
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if(!canWin(t)){
                    return true;
                }
            }
        }
        return false;
    }
}