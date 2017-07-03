public class Solution {
    // Math
    public int integerBreak(int n) {
        if(n <= 3) return n-1;
        int mod = n % 3;
        if(mod == 0)    return (int)Math.pow(3, n/3);
        if(mod == 1)    return (int)(4 * Math.pow(3, (n-4)/3));
        return (int)(2 * Math.pow(3, n/3));
    }
    
    // Memoization
    public int integerBreak(int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(n == 1 || n == 2)    return 1;
        map.put(1, 1); map.put(2, 2);
        findMax(map, n);
        return map.get(n);
    }
    
    public int findMax(HashMap<Integer, Integer> map, int n){
        if(map.containsKey(n))  return map.get(n);
        int max = 0;
        for(int i = 1; i <= n/2; i++){
            int a = findMax(map, i), b = findMax(map, n - i);
            max = Math.max(b * i, Math.max(a * (n - i), Math.max(i * (n - i), Math.max(a * b, max))));
        }
        map.put(n, max);
        return max;
    }
    // DP
    // O(n) space, O(n^2) time
    public int integerBreak(int n) {
       int[] dp = new int[n + 1];
       dp[1] = 1;
       for(int i = 2; i <= n; i ++) {
           for(int j = 1; j < i; j ++) {
               dp[i] = Math.max(dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])));
           }
       }
       return dp[n];
    }
}