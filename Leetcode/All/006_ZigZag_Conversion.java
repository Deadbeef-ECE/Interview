public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <= 0)
            return "";
        if(numRows == 1)    return s;
        
        String ret = "";
        int size = 2 * numRows - 2; //k + (k -2)
        for(int i = 0; i < numRows; i++){
            for(int j = i; j < s.length(); j += size){
                ret += s.charAt(j);
                if(i != 0 && i != numRows - 1){
                    int temp = j + size - 2 * i;
                    if(temp < s.length())
                        ret += s.charAt(temp);
                }
            }
        }
        return ret;
     } 
}