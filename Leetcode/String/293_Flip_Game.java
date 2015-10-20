public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ret = new LinkedList<String>();
        for(int i = 0; i <= s.length() - 2; i++){
            if(!s.substring(i, i + 2).equals("++"))    continue;
            String sol = "";
            if(i == 0)
                sol = "--" + s.substring(i + 2, s.length());
            else
                sol = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
            ret.add(sol);
        }
        return ret;
    }

    // Use startWith() method of String
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 2)    return res;
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i))
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
        }
        
        return res;
    }
}