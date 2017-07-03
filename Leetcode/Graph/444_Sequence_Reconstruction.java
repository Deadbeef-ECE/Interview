public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        HashMap<Integer, Integer> in = new HashMap<Integer, Integer>();
        buildGraph(seqs, map, in);
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i : in.keySet()){
            if(in.get(i) == 0)  queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(size > 1)    return false;
            int from = queue.poll();
            if(count == org.length || from != org[count++])    return false;
            for(int to : map.get(from)){
                in.put(to, in.get(to) - 1);
                if(in.get(to) == 0) queue.add(to);
            }
        }
        return count == org.length && count == map.size();
    }
    
    public void buildGraph(List<List<Integer>> seqs, HashMap<Integer, Set<Integer>> map, HashMap<Integer, Integer> in){
        for(List<Integer> arr : seqs){
            if(arr.size() == 0) continue;
            if(!map.containsKey(arr.get(0))){
                map.put(arr.get(0), new HashSet<Integer>());
                in.put(arr.get(0), 0);
            }
            for(int i = 1; i < arr.size(); i++){
                if(!map.containsKey(arr.get(i))) {
                    map.put(arr.get(i), new HashSet<Integer>());
                    in.put(arr.get(i), 0);
                }
                if(map.get(arr.get(i - 1)).contains(arr.get(i)))    continue;
                map.get(arr.get(i - 1)).add(arr.get(i));
                in.put(arr.get(i), in.get(arr.get(i)) + 1);
            }
        }
    }
}