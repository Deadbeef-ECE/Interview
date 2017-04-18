public class Solution {
    // O(n) space, O(n) time
    public String reverseWords(String s) {
        if(s.length() == 0)   return s;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int j = 0;
        int i = 0;
        for(i = 0; i < n; i++){
            if(s.charAt(i) == ' '){
                String part = s.substring(j, i);
                sb.append(new StringBuffer(part).reverse().toString());
                if(i != n){
                    sb.append(' ');
                    j = i + 1;
                }
                continue;
            }
        }
        String part = s.substring(j, i);
        sb.append(new StringBuffer(part).reverse().toString());
        return sb.toString();
    }
}