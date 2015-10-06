public class Solution {
    // Brute force:
    public int countPrimes(int n) {
        int cnt = 0;
        for(int i = 2; i <= n; i++){
            if(isPrime(i))  cnt++;
        }
        return cnt;
    }
    private boolean isPrime(int n){
        if (n <= 1) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0)  return false;
        }
        return true;
    }
    
    // Sieve method
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