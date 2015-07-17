public class Solution {
    // O(1) space, O(n) time
    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        int len = Math.max(alen, blen);
        int carry = 0;
        
        String ret = "";
        for(int i = 0; i < len; i++){
            int v1 = i < alen ? a.charAt(alen -1 - i) - '0' : 0;
            int v2 = i < blen ? b.charAt(blen -1 - i) - '0' : 0;
            int digit = (carry + v1 + v2) % 2;
            carry = (carry + v1 + v2)/ 2;
            ret = digit + ret;
        } 
        if(carry == 1)
            ret = 1 + ret;
        return ret;
    }
}