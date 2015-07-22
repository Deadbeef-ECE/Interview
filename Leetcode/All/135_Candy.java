public class Solution {
    // O(n) time, O(n) space
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int[] state = new int[ratings.length];
        state[0] = 1;
        
        // 从左往右扫，如果后大于前，后＝前+1，否则为1
        for(int i = 1; i < ratings.length; i++)
            state[i] = ratings[i] > ratings[i-1] ? state[i-1] + 1 : 1;
        
        int sum = state[ratings.length - 1];
        // 从右往左扫，如果前大于后，前＝Max(后+1，前)
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1])
                state[i] = Math.max(state[i+1] + 1, state[i]);
            sum += state[i];
        }
        return sum;
    }
}