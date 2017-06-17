public class Solution {
    // O(1) space, O(n) time
    // substring会占用额外空间
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

    // Two-pointer:
    // O(n) time, O(1) space
    public boolean isOneEditDistance(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if(Math.abs(l1 - l2) > 1)   return false;
        int i = 0, j = 0;
        int diff = 0;
        while(i < l1 && j < l2 && diff < 2){
            if(s.charAt(i) == t.charAt(j)){
                i++;j++;
                continue;
            }
            if(l1 > l2){
                i++;
            }else if(l1 == l2){
                i++;j++;
            }else{
                j++;
            }
            diff++;
        }
        if(diff == 2)   return false;
        if(diff == 0 && l1 == l2)   return false;
        return true;
    }
}