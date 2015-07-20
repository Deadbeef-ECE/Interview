public class Solution {
    // O(n) space, O(n^2) time
    public int countPrimes(int n) {
        int ret = 0;
        if(n <= 2)   return 0;
        boolean[] table = new boolean[n+1];
        table[2] = true;
        for(int i = 3; i < n; i+=2)
            table[i] = true;
        for(int i = 2; i < n; i++){
            if(table[i] == true){
                ret++;
                for(int j = 2; i * j < n; j++){
                    table[i*j] = false;
                }
            }
        }
        return ret;
    }
}