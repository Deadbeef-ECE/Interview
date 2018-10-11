class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0)
            return 0;
        
        int res = 0;
        res += duration;
        int preEnd = timeSeries[0] + duration - 1;
        for(int i = 1; i < timeSeries.length; i++){
            int curEnd = timeSeries[i] + duration - 1;
            int curStart = timeSeries[i];
            res += duration;
            if(curStart <= preEnd){
                res = res - (preEnd - curStart + 1);
            }
            preEnd = curEnd;
        }
        return res;
    }
}