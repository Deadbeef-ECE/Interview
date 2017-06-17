public class Solution {
    //O(n) time, O(n) space
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = S.length() - 1; i >= 0; i--){
            char c = S.charAt(i);
            if(cnt != 0 && cnt % K == 0){
                sb.insert(0, '-');
                cnt = 0;
            }
            if(Character.isDigit(c)){
                sb.insert(0, c);
                cnt++;
            }else if(Character.isLetter(c)){
                sb.insert(0, Character.toUpperCase(c));
                cnt++;
            }
        }
        if(sb.length() > 0 && sb.charAt(0) == '-')
            sb.deleteCharAt(0);
        return sb.toString();
    }
    //超简洁版本
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(S);
        // Starting from the end of sb, and going backwards. 
        int i = sb.length() - K;
        while(i > 0) {
            sb.insert(i, '-');
            i = i - K;
        }
        return sb.toString();
    }
}