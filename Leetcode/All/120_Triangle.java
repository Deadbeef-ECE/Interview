public class Solution {
    // Top-Down Solution:
    // O(n) space, 
    // O(n^2) time if n is the dp array size
    // Or O(n) time if n is the total numbers of integers of triangle
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.get(triangle.size()-1).size();
        int[] dp = new int[size];
        
        for(List<Integer> list: triangle){
            int len = list.size();
            for(int i = len - 1; i >= 0; i--){
                if(i == 0){
                    dp[i] = dp[i] + list.get(i);
                    continue;
                }
                if(i == len - 1){
                    dp[i] = dp[i - 1] + list.get(i);
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-1]) + list.get(i);
            }
        }
        
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++)
            ret = Math.min(ret, dp[i]);
        return ret;
    }
    // Bottom-Up Solution:
    // O(n) space, 
    // O(n^2) time if n is the dp array size
    // Or O(n) time if n is the total numbers of integers of triangle
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size+1];
        
        for(int i = size - 1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}