public class Solution {
    // O(1) space, O(n^2) time ?
    public String countAndSay(int n) {
        String prev = "1";
        for(int i = 1; i < n; i++){
            StringBuilder str = new StringBuilder();
            int cnt = 1;
            int j;
            for(j = 1; j < prev.length(); j++){
                if(prev.charAt(j) == prev.charAt(j-1)){
                    cnt++;
                }else{
                    str.append(String.valueOf(cnt));
                    str.append(prev.charAt(j-1));
                    cnt = 1;
                }
            }
            str.append(String.valueOf(cnt));
            str.append(prev.charAt(prev.length()-1));
            prev = str.toString();
        }
        return prev;
    }
}