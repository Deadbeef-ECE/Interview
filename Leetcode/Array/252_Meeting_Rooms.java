/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    // O(1) space, O(nlogn)time
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length == 0)
            return true;
        Arrays.sort(intervals, new intervalComparator());
        int end = intervals[0].end;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < end)
                return false;
            end = intervals[i].end;
        } 
        return true;
    }
}

class intervalComparator implements Comparator<Interval>{
    public int compare(Interval a, Interval b){
        return a.start - b.start;
    }
}