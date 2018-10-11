class Solution {
    public String toGoatLatin(String S) {
        if(S == null || S.length() == 0)
            return S;
        S = S.trim();
        String[] strs = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            char start = str.charAt(0);
            if("aeiouAEIOU".indexOf(start) != -1){
                sb.append(str);
            }else{
                sb.append(str.substring(1)).append(start);
            }
            sb.append("ma");
            int temp = i + 1;
            while(temp-- > 0)
                sb.append("a");
            if(i < strs.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }
}