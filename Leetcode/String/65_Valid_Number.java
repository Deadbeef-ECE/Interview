public class Solution {
    // O(1) space, O(n) time
    public boolean isNumber(String s) {
        if(s == null)   return false;
        s = s.trim();
        if(s.length() == 0) return false;
        boolean E = false;
        boolean dot = false;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '.':
                    if(dot || E)    return false;
                    if(i == 0){
                        if(s.length() == 1) return false;
                        if(s.charAt(i+1) < '0' || s.charAt(i+1) > '9')
                            return false;
                    }
                    if(i == s.length()-1){
                        if(s.charAt(i-1) < '0' || s.charAt(i-1) > '9')
                            return false;
                    }
                    dot = true;
                    break;
                case '+':
                case '-':
                    if(i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')
                        return false;
                    if(i == s.length()-1)   return false;
                    if(s.charAt(i+1) != '.' && !(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9')) 
                        return false;
                    break;
                case 'e':
                case 'E':
                    if(i == 0 || i == s.length() - 1 || E)
                        return false;
                    E = true;
                    break;
                default:
                    if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                        return false;
            }
        }
        return true;
    }
}