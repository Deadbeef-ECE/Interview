public class Solution {
    // space, time?
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)    return "0";
        String ret = "";
        if((numerator < 0) ^ (denominator < 0))
            ret += "-";
            
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        long quotient = num / den;
        long remainder = num % den;
        ret += quotient;
        if(remainder == 0)   return ret;
        ret += ".";
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while(remainder != 0){
            remainder *= 10;
            if(map.containsKey(remainder)){
                String part1 = ret.substring(0, map.get(remainder));
                String part2 = ret.substring(map.get(remainder));
                ret = part1 + "(" + part2 + ")";
                return ret;
            }
            quotient = remainder / den;
            map.put(remainder, ret.length());
            ret += quotient;
            remainder = remainder % den;
        }
        return ret;
    }
}