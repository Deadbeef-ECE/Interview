public class Solution {
    // Use split():
    // O(n) space, O(n) time
    public String reverseWords(String s) {
        if(s.length() == 0)  return "";
        s = s.trim();
        String[] words = s.split(" ");
        s = "";
        for(int i = words.length - 1; i >= 0; i--){
            if(!words[i].isEmpty()){
                s += words[i] + " ";
            }
        }
        return s.trim();
    }
    
    // no split():
    // O(1) space, O(n) time;
    public String reverseWords2(String s) {
        if(s == null || s.length() == 0)
            return s;
        int start = 0, end = 0;
        String ret = "";
        while(end < s.length()){
            while(end < s.length() && s.charAt(end) == ' ')
                end++;
            start = end;
            while(end < s.length() && s.charAt(end) != ' ')
                end++;
            String word = s.substring(start, end);
            ret = word + " " + ret;
        }
        return ret.trim();
    }
}