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
    // O(n) space, O(n) time
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null)
            return intervals;
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        List<Interval> ret = new LinkedList<Interval>();
        for(Interval cur : intervals){
            if(cur.end < newInterval.start){
                ret.add(cur);
            }else if(cur.start > newInterval.end){
                ret.add(newInterval);
                newInterval = cur;
            }else{
                newInterval.start = Math.min(newInterval.start, cur.start);
                newInterval.end = Math.max(newInterval.end, cur.end);
            }
        }
        ret.add(newInterval);
        return ret;
    }
}