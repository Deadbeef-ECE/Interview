// 57 follow up
// input list是乱序的情况, 仍然没有overlap
// 需要写一个comparator先排序，再insert
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

class intervalCompartor implements Comparator<Interval>{
	public int compare(Interval a, Interval b){
		return a.start - b.start;
	}
}

public class InsertIntervals {
	// O(n) space, O(nlogn) time
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null)
            return intervals;
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        Collections.sort(intervals, new intervalCompartor());
        System.out.println("after sorting intervals:");
        printList(intervals);

        List<Interval> ret = new LinkedList<Interval>();
        for(Interval cur : intervals){
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
    	Interval elem2 = new Interval(7,10);
    	Interval elem3 = new Interval(5,8);
    	Interval elem4 = new Interval(18,22);
    	Interval elem5 = new Interval(13,15);
    	Interval newInterval1 = new Interval(4, 9);
    	intervals.add(elem1);
    	intervals.add(elem2);
    	intervals.add(elem3);
    	intervals.add(elem4);
    	intervals.add(elem5);
    	printList(intervals);
    	List<Interval> ret = insert(intervals, newInterval1);
    	printList(ret);
    }
    
    private static void printList(List<Interval> intervals){
    	for(Interval cur : intervals){
    		System.out.print("["+ cur.start + ","+ cur.end+"]"+" ");
    	}
    	System.out.println();
    }
}
