public class Solution {
    // 此题很无聊
    String valid = "0123456789abcdefABCDEF.:";
    public String validIPAddress(String IP) {
        try{
            if(IP == null || IP.length() == 0)  return "Neither";
            if(validIPv4(IP))   return "IPv4";
            if(validIPv6(IP))   return "IPv6";
        }catch(NumberFormatException e){
            return "Neither";
        }
        return "Neither";
    }
    
    public boolean validIPv4(String IP){
        try{
            if(IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.')
                return false;
            String[] segs = IP.split("\\.");
            if(segs.length != 4)    return false;
            for(int i = 0; i < 4; i++){
                int n = Integer.parseInt(segs[i]);
                if(n < 0 || n > 255)    return false;
                if(segs[i].charAt(0) == '0' && n > 0)    return false;
                if(n == 0 && segs[i].length() > 1) return false;
            }
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public boolean validIPv6(String IP){
        if(IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':')
            return false;
        String[] segs = IP.split("\\:");
        if(segs.length != 8)    return false;
        for(int i = 0; i < segs.length; i++){
            String s = segs[i];
            if(s.length() > 4 || s.length() == 0)  return false;
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(valid.indexOf(c) == -1)   return false;
                if(!Character.isDigit(c) && Character.toLowerCase(c) - 'a' > 'f' - 'a')
                    return false;
            }
        }
        return true;
    }

    // Regular expression solution:
    public String validIPAddress(String IP) {
        if(IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"))
                return "IPv4";
        if(IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})"))
                return "IPv6";
        return "Neither";
    }
}