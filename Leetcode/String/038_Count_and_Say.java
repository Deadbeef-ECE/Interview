public class Solution {
    // O(1) space, O(n^2) time ?
    public String countAndSay(int n) {
        if(n < 1)   return "";
        String str = "1";
        for(int i = 2; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for(int j = 1; j < str.length(); j++){
                if(str.charAt(j) == str.charAt(j - 1))
                    cnt++;
                else{
                    sb.append(cnt);
                    sb.append(str.charAt(j - 1));
                    cnt = 1;
                }
            }
            sb.append(cnt);
            sb.append(str.charAt(str.length() - 1));
            str = sb.toString();
        }
        return str;
    }
}