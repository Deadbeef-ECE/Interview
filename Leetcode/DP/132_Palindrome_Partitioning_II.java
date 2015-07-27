public class Solution {
    
    public int minCut(String s) {
        int min = 0;
        int len = s.length();
        if(len < 1)
            return min;
        boolean[][] matrix = new boolean[len][len];
        int[] cuts = new int[len+1];
        
        for(int i = 0; i < len; i++){
            cuts[i] = len - i;
        }
        
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; ++j){
                if ((s.charAt(i) == s.charAt(j) &&((j-i<2)  
                    || matrix[i+1][j-1])))  {  
                    matrix[i][j] = true;  
                    cuts[i] = Math.min(cuts[i], cuts[j+1]+1);  
                }  
            }
        }
        return cuts[0] - 1;
    }
}