public class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0;
        int pIdx = 0;
        int starPos = -1;
        int start = -1;
        while(sIdx < s.length()){
            if(pIdx < p.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?')){
                sIdx++;
                pIdx++;
            }else if(pIdx < p.length() && p.charAt(pIdx) == '*'){
                starPos = pIdx;
                start = sIdx;
                pIdx++;
            }else if(starPos != -1){
                sIdx = ++start;
                pIdx = starPos + 1;
            }else{
                return false;
            }
        }
        while(pIdx < p.length() && p.charAt(pIdx) == '*')
            pIdx++;
        return pIdx == p.length() && sIdx == s.length();
    }
}