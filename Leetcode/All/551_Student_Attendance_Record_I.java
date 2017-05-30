public class Solution {
    public boolean checkRecord(String s) {
        int absentCnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(i > 1 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) =='L')
                return false;
            if(s.charAt(i) == 'A')
                absentCnt++;
        }
        if(absentCnt > 1)   return false;
        return true;
    }
    // Radix
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}