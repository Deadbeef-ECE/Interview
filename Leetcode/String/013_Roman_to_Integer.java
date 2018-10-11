public class Solution {
    // O(1) space, O(n) time
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i > 0 && char2num(s.charAt(i - 1)) < char2num(c)){
                res -= 2 * char2num(s.charAt(i - 1));
            }
            res += char2num(c);
        }
        return res;
    }
    
    
    private int char2num(char c){
        switch(c){
            case 'I':   return 1;
            case 'V':   return 5;
            case 'X':   return 10;
            case 'L':   return 50;
            case 'C':   return 100;
            case 'D':   return 500;
            case 'M':   return 1000;
            default:    return 0;
        }
    }
}