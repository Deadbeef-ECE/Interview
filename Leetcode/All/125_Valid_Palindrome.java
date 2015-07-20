public class Solution {
    // O(1) space, O(n) time
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(!isValid(s.charAt(start))){
                start++;
                continue;
            }
            if(!isValid(s.charAt(end))){
                end--;
                continue;                
            }
            if(!isSame(s.charAt(start), s.charAt(end)))
                return false;
            start++; end--;
        }
        return true;
    }
    
    private boolean isValid(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
            (c >= '0' && c <= '9'))
            return true;
        return false;
    }
    
    private boolean isSame(char a, char b){
        if(a >= 'a' && a <= 'z')
            a = (char)(a - 'a' + 'A');
        if(b >= 'a' && b <= 'z')
            b = (char)(b - 'a' + 'A');
        return a == b;
    }
}