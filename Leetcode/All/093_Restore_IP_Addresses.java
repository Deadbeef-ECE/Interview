public class Solution {
    // TODO: 
    // O() time
    // O() space
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new LinkedList<String>();
        if(s.length() > 12) return ret;
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
    
    private boolean isValid(String s){
        if(s.charAt(0) == '0' && s.length() > 1)
            return false;
        int val = Integer.valueOf(s);
        if(val < 0 || val > 255)
            return false;
        return true;
    }
}