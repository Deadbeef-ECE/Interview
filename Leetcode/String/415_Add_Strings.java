public class Solution {
    // O(n) time, O(1) space
    public String addStrings(String num1, String num2) {
        String sum = "";
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int v1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int v2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int cur = v1 + v2 + carry;
            int digit = cur % 10;
            carry = cur / 10;
            sum = digit + sum;
        }
        if(carry == 1)  sum = "1" + sum;
        return sum;
    }
}