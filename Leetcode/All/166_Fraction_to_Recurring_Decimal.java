public class Solution {
    // space, time?
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)  return "0";
        String ret = "";    
        if ((numerator < 0) ^ (denominator < 0))
            ret += "-";  
        long num = Math.abs((long)numerator);  
        long den = Math.abs((long)denominator);

        long quotient = num/den;
        long remainder = num % den;
        ret += String.valueOf(quotient);
        if(remainder == 0){
            return ret;
        }else{
            ret += ".";
        }
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        remainder *= 10;
        while(remainder != 0){
            if(map.containsKey(remainder)){
                int pos = map.get(remainder);
                String part1 = ret.substring(0, pos);
                String part2 = ret.substring(pos, ret.length());
                ret = part1 + "(" + part2 + ")";
                return ret;
            }
            map.put(remainder, ret.length());
            quotient = remainder / den;
            ret += String.valueOf(quotient);
            remainder = (remainder % den)*10;
        }
        return ret;
    }
}