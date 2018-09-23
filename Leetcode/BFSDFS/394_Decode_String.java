class Solution {
    public String decodeString(String s) {
        return decode(s);
    }
    
    private String decode(String s){
        if(s.length() == 0) return "";
        String ret = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int digitStart = i;
                while(s.charAt(i) != '[')   i++;
                int num = Integer.parseInt(s.substring(digitStart, i));
                
                int cnt = 1;
                int strStart = ++i;
                while(cnt != 0){
                    if(s.charAt(i) == '[')  cnt++;
                    else if(s.charAt(i) == ']') cnt--;
                    i++;
                }
                // abc]x -> point to x now, we need index of ']' 
                i--;
                String str = decode(s.substring(strStart, i));
                for (int j = 0; j < num; j++){
                    ret = ret + str;
                }
            }else{
                ret += c;
            }
        }
        return ret;
    }
}