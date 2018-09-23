class Solution {
    // 愚蠢的recursion
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length - 1;
        return dfs(bits, n - 1);
    }
    
    private boolean dfs(int[] bits, int n){
        if(n < 0)   return true;
        if(n == 0)  return bits[n] == 0;
        boolean ret = false;
        if(bits[n - 1] == 1 && (bits[n] == 0 || bits[n] == 1)){
            ret |= dfs(bits, n - 2);
        }
        if(bits[n] == 0)
            ret |= dfs(bits, n - 1);
        return ret;
    }
    // 聪明的解法
    public boolean isOneBitCharacter(int[] bits) {
        int ones = 0;
        //Starting from one but last, as last one is always 0.
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0 ; i--) { 
            ones++;
        }
        if (ones % 2 > 0) return false; 
        return true;
    }
}