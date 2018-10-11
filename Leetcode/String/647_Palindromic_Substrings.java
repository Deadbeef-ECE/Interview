class Solution {
    int cnt = 0;
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0)
            return cnt;
        for(int i = 0; i < s.length(); i++){
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return cnt;
    }
    
    private void extend(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            cnt++;
            i--;
            j++;
        }   
    }
}