public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        
        return start / s.length();
    }
}

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        
        int i = 0;
        int j = 0;
        int k = 0;
        int cnt = 0;
        while(i < rows){
            if(j + sentence[k].length() <= cols){
                j += sentence[k].length();
                k++;
                if(k == sentence.length){
                    k = 0;
                    cnt++;
                }
                if(j < cols){
                    j++;
                }
                else{
                    j = 0;
                    i++;
                }
            }else{
                i++;
                j = 0;
            }
        }
        return cnt;
    }
}