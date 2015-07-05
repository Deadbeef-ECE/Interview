public class Solution {
    // 
    public String longestCommonPrefix(String[] strs) {
        int num = strs.length;
        String ret = "";
        if(num == 0 || strs.length == 0)
            return ret;
        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 0; j < num; j++){
                if(strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
}