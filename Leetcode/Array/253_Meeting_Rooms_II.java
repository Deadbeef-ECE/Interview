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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new SortComparator());
        PriorityQueue<Interval> heap = 
        new PriorityQueue<Interval>(intervals.length, new HeapComparator());
        heap.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            Interval intv = heap.peek();
            if(intv.end <= intervals[i].start)
                heap.poll();
            heap.offer(intervals[i]);
        }
        return heap.size();
    }
}

class SortComparator implements Comparator<Interval>{
    public int compare(Interval a, Interval b){
        return a.start - b.start;
    }
}

class HeapComparator implements Comparator<Interval>{
    public int compare(Interval a, Interval b){
        return a.end - b.end;
    }
}