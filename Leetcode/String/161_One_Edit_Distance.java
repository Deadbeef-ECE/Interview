public class Solution {
    // O(1) space, O(n) time
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(Math.abs(sLen - tLen) > 1)   return false;
        if(sLen == tLen)
            return canReplace(s, t, sLen);
        return isOneEdit(s, t, sLen, tLen);
    }
    
    private boolean canReplace(String s, String t,int Len){
        int cnt = 0;
        for(int i = 0; i < Len; i++){
            if(s.charAt(i) != t.charAt(i))
                cnt++;
        }
        return cnt == 1;
    }
    
    private boolean isOneEdit(String s, String t, int sLen, int tLen){
        int Min = Math.min(sLen, tLen);
        for(int i = 0; i < Min; i++){
            if(i == Min)    return true;
            if(s.charAt(i) != t.charAt(i)){
                if(sLen > tLen)
                    return s.substring(i+1).equals(t.substring(i));
                else
                    return s.substring(i).equals(t.substring(i+1));
            }
        }
        return true;
    }
}