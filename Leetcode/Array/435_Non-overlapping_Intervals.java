class Solution {
     public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a.end - b.end);
        int curEnd = intervals[0].end, count = 0;
        for (int i = 1; i < intervals.length; i++){
            if (curEnd <= intervals[i].start){
                curEnd = intervals[i].end;
            }else{
                count++;
            }
        }
        return count;
    }
}