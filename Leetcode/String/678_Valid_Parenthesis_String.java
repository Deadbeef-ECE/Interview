class Solution {
    public boolean checkValidString(String s) {
        int maxLeft = 0;
        int minLeft = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                maxLeft++;
                minLeft++;
            }else if(c ==')'){
                if(minLeft > 0)
                    minLeft--;
                maxLeft--;
            }else{
                if(minLeft > 0)
                    minLeft--;
                maxLeft++;
            }
            if(maxLeft < 0)
                return false;
        }
        return minLeft == 0;
    }
}

// maxLeft is tracking maximum number of open braces possible '('.
// if it encounters a *, it considers it as '('

// minLeft is tracking minimum number of open braces.
// If it encounters a *, it considers it as ')'

// In the end, if maxLeft is negative, that means there were too many ')'