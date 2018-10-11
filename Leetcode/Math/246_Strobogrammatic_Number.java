public class Solution {
    // NiuBi solution:
    // O(1) space, O(n) time
    public boolean isStrobogrammatic(String num) {
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--)
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
        return true;
    }

    // Two pointer solution:
    // O(1) space, O(n) time
    public boolean isStrobogrammatic(String num) {
        int l = 0, r = num.length() - 1;
        while(l <= r){
            char a = num.charAt(l++);
            char b = num.charAt(r--);
            if(!isStro(a, b))   return false;
        }
        return true;
    }
    
    private boolean isStro(char a, char b){
        if(a == '6')    return b == '9';
        if(a == '9')    return b == '6';
        if(a == '1')    return b == '1';
        if(a == '8')    return b == '8';
        if(a == '0')    return b == '0';
        return false;
    }
}