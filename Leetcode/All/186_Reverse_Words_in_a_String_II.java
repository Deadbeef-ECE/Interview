public class Solution {
    // O(1) space, O(n) time
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0)
            return;
        // reverse whole string
        reverse(s, 0, s.length-1);
        int start = 0;
        // reverse word one by one
        for(int i = 0; i <= s.length; i++){
            if(i == s.length || s[i] == ' '){
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
    }
    
    private void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;end--;
        }
    }
}