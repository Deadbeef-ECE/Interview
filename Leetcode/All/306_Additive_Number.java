public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 2)    return false;
        
        for(int i = 1; i <= num.length()/2; i++){
            for(int j = i + 1; j <= 2 * num.length() / 3; j++){
                // the second number cannot has leading 0
                if(num.charAt(i) == '0' && j - i > 1)   break;  
                if(helper(num.substring(0, i), num.substring(i, j), num.substring(j)))
                    return true;
            }
        }
        return false;
    }
    
    private boolean helper(String num1, String num2, String rest){
        String sum = add(num1, num2);
        if(sum.equals(rest))    return true;
        if(sum.length() >= rest.length() || !sum.equals(rest.substring(0, sum.length())))
            return false;
        return helper(num2, sum, rest.substring(sum.length()));
    }
    
    private String add(String num1, String num2){
        int carry = 0;
        String ret = "";
        int len = Math.max(num1.length(), num2.length());
        for(int i = 0; i < len; i++){
            int total = carry;
            int A = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int B = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            total += A + B;
            ret = total % 10 + ret;
            carry = total / 10;
        }
        if(carry != 0)  ret = carry + ret;
        return ret;
    }
}