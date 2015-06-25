import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class FindTopKFrequncyNum {
	public static void main(String [] args){
		int[] A = {1, 1, 2, 3, 3, 3, 4, 4, 4, 4, 4, 9, 9, 9, 9, 5, 7, 2};
		System.out.println(HashMapMethod(A, 3).toString());
	}
	
	public static Set<Integer> HashMapMethod(int[] A, int k){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int num : A){
			if(map.containsKey(num)){
				map.put(num, map.get(num)+1);
			}else{
				map.put(num, 1);
			}
		}
		ArrayList<Entry<Integer, Integer>> list =
		new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
				return b.getValue() - a.getValue();
			}
		});
		for(int i = 0; i < k; i++)
			set.add(list.get(i).getKey());
		return set;
	}
	
	public static List<Integer> findKthFrenquency(int[] input, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: input) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        PriorityQueue<Entry<Integer, Integer>> q = 
        new PriorityQueue<Entry<Integer, Integer>>(k + 1, 
        		new Comparator<Entry<Integer, Integer>>(){
           public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
               return b.getValue() - a.getValue();
           }
        });

        for (Entry<Integer, Integer> entry: map.entrySet()) {
            if (q.size() == k + 1) {
                // Delete the smallest element from the queue.
                q.poll();
            }
            q.offer(entry);
        }

        // delete one small element
        q.poll();
        while (!q.isEmpty()) {
            Entry<Integer, Integer> entry1 = q.poll(); 
            list.addFirst(entry1.getKey());
        }

        return list;
        }
}
