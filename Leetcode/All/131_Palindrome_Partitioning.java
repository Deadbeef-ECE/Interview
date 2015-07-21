public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<List<String>>();
        if(s == null || s.length() == 0)
            return ret;
        List<String> path = new LinkedList<String>();
        doDFS(0, s, path, ret);
        return ret;
    }
    
    private void doDFS(int start, String s, List<String> path, List<List<String>> ret){
        if(start == s.length()){
            List<String> sol = new LinkedList<String>(path);
            ret.add(sol);
            return;
        }
        
        for(int i = start + 1; i <= s.length(); i++){
            String cur = s.substring(start, i);
            if(isPalindrome(cur)){
                path.add(cur);
                doDFS(i, s, path, ret);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++; r--;
        }
        return true;
    }
}