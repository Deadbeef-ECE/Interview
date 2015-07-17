// 57 follow up2
// input list是乱序的情况且有overlap
// 要先merge, 因为sort后可能出现两个一样的，并且其end小于newInterval.start
// 例如: sorted 后是[1,3], [1,3], [7,8]...   newInterval [4,5]
// 如果不先merge, 最后就是[1,3], [1,3], [4,5], [7,8]... 
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class intervalCompartor2 implements Comparator<Interval>{
    public int compare(Interval a, Interval b){
        //if(a.start != b.start)
            return a.start - b.start;
        //return a.end - b.end;
    }
}

public class InsertIntervals2 {
    // O(n) space, O(nlogn) time
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null)
            return intervals;
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        // sort input intervals
        Collections.sort(intervals, new intervalCompartor2());
        printList("after sorting:", intervals);
        // merge input intervals
        List<Interval> merged = new LinkedList<Interval>();
        Interval pre = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval temp = intervals.get(i);
            if(pre.end >= temp.start){
                pre.end = Math.max(temp.end, pre.end);
            }else{
                merged.add(pre);
                pre = temp;
            }
        }
        merged.add(pre);
        printList("after merging:", merged);
        
        // insert newInterval
        List<Interval> ret = new LinkedList<Interval>();
        for(Interval cur : merged){
            if(cur.end < newInterval.start){
                ret.add(cur);
            }else if(cur.start > newInterval.end){
                ret.add(newInterval);
                newInterval = cur;
            }else{
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            }
        }
        ret.add(newInterval);
        return ret;
    }

    public static void main(String[] args){
        List<Interval> intervals = new LinkedList<Interval>();
        Interval elem1 = new Interval(1,3);
        Interval elem2 = new Interval(1,3);
        Interval elem3 = new Interval(4,7);
        Interval elem6 = new Interval(8,11);
        Interval elem4 = new Interval(18,22);
        Interval elem5 = new Interval(13,15);
        Interval newInterval1 = new Interval(5, 12);
        intervals.add(elem1);
        intervals.add(elem2);
        intervals.add(elem3);
        intervals.add(elem6);
        intervals.add(elem4);
        intervals.add(elem5);
        printList("Original list:", intervals);
        List<Interval> ret = insert(intervals, newInterval1);
        printList("ret:",ret);
    }
    
    private static void printList(String str, List<Interval> intervals){
        System.out.println(str);
        for(Interval cur : intervals){
            System.out.print("["+ cur.start + ","+ cur.end+"]"+" ");
        }
        System.out.println();
    }
}
