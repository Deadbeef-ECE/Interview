public class Solution {
    // O(1) space or O(n) space if consider the implicit space inside trim()
    // O(n) time
    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        boolean isNeg = false;
        str = str.trim();
        if(str.length() == 0)   return 0;
        
        // determine negative or positive
        int i = 0;
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            if(str.charAt(i) == '-')
                isNeg = true;
            i++;
        }
        
        // convert number
        int ret = 0;
        while(i < str.length()){
            if(str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            int digit = (int)(str.charAt(i) - '0');
            // positive number && overflow
            if(!isNeg && ret > (Integer.MAX_VALUE - digit)/10)
                return Integer.MAX_VALUE;
            // negative number && overflow
            if(isNeg && ret > -((Integer.MIN_VALUE + digit)/10))
                return Integer.MIN_VALUE;
            ret = 10 * ret + digit;
            i++;
        }
        
        return isNeg ? -ret : ret;
    }
}