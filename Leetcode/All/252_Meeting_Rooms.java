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

// Better Average running time with exception
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null)   return true;
        try{
            Arrays.sort(intervals, new IntervalComparator());
        }catch(Exception E){
            return false;
        }
        return true;
    }
}
class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval a, Interval b){
        if(a.start > b.start && a.start >= b.end)   
            return 1;
        else if(a.start < b.start && a.end <= b.start)  
            return -1;
        else 
            throw new RuntimeException();
    }
}