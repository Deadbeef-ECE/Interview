public class Solution {
    // O(n^4) time:
    // n is s.length()

    // O(1) space:
    // recursion stack 最高也就是4了, 所以O(1) space
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<String>();
        if(s.length() < 4 || s.length() > 12) 
            return ret;
        String path = "";
        int seg = 0;
        doDFS(path, s, seg, ret);
        return ret;
    }
    
    private void doDFS(String path, String rest, int seg, List<String> ret){
        if(seg == 3 && isValid(rest)){
            path += rest;
            ret.add(path);
            return;
        }
        
        for(int i = 1; i < 4 && i < rest.length(); i++){
            String cur = rest.substring(0, i);
            if(isValid(cur)){
                if(seg + 1 > 3) return;
                doDFS(path + cur + ".", rest.substring(i), seg + 1, ret);
            }
        }
    }
    
    public boolean isValid(String str){
        int n = Integer.parseInt(str);
        if(n > 0 && n <= 255)
            return str.charAt(0) != '0';   
        return n == 0 && str.length() == 1;
    }

    // Iteration:
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<String>();
        if(s.length() < 4 || s.length() > 12)  return ret;
        String str1 = "", str2 = "", str3 = "", str4 = "";
        
        for(int i = 1; i <= 3; i++){
            str1 = s.substring(0, i);
            if(!isValid(str1))   continue;
            for(int j = i + 1; j <= i + 3 && j <= s.length(); j++){
                str2 = s.substring(i, j);
                if(!isValid(str2))   continue;
                for(int k = j + 1; k <= j + 3 && k <= s.length() - 1; k++){
                    if(s.length() - k > 3) 
                        continue;
                    str3 = s.substring(j, k);
                    str4 = s.substring(k, s.length());
                    if(isValid(str3) && isValid(str4)){
                        String sol = str1 + "." + str2 + "." + str3 + "." + str4;
                        ret.add(sol);
                    }
                }
            }
        }
        return ret;
    }
}