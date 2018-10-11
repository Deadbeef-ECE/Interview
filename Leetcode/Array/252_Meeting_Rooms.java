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
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end)
                return false;
        }
        return true;
    }
}

// Beats 93%
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        int[] s = new int[intervals.length];
        int[] e = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            s[i] = intervals[i].start;
            e[i] = intervals[i].end;
        }
        Arrays.sort(s);
        Arrays.sort(e);
        for(int i = 1; i < intervals.length; i++){
            if(s[i] < e[i - 1])
                return false;
        }
        return true;
    }
}