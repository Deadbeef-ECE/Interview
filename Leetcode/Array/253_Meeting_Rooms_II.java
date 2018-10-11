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
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a, b) -> (a.end - b.end));
        pq.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            Interval cur = pq.peek();
            if(intervals[i].start >= cur.end)   pq.poll();
            pq.offer(intervals[i]);
        }
        
        return pq.size();
    }

    // 最优解
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[] sT = new int[n];
        int[] eT = new int[n];
        int idx = 0;
        for (Interval interval : intervals) {
            sT[idx] = interval.start;
            eT[idx] = interval.end;
            idx++;
        }
        Arrays.sort(sT);
        Arrays.sort(eT);
        int count = 0;
        int endPtr = 0;
        for (int i = 0; i < n; i++) {
            if (sT[i] < eT[endPtr]) {
                countß++;
            } else {
                endPtr++;
            }
        }
        return count;
    }
}