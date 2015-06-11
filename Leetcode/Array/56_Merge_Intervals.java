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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new LinkedList<Interval>();
        if(intervals == null || intervals.size() == 0)
            return ret;
        Collections.sort(intervals, new intervalComparator());
        Interval pre = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval temp = intervals.get(i);
            if(pre.end >= temp.start){
                pre.end = Math.max(pre.end, temp.end);
            }else{
                ret.add(pre);
                pre = temp;
            }
        }
        ret.add(pre);
        return ret;
    }
}

class intervalComparator implements Comparator<Interval>{
    public int compare(Interval a, Interval b){
        return a.start - b.start;
    }
}