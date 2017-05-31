public class Solution {
    public String findContestMatch(int n) {
        String[] m = new String[n];
        
        for(int i = 1; i <= n; i++)
            m[i-1] = String.valueOf(i);

        while(n > 1){
            for(int i = 0; i < n/2; i++){
                m[i] = "(" + m[i] + "," + m[n - 1 - i] + ")";
            }
            n /= 2;
        }
        return m[0];
    }
}