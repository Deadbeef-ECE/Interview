public class Solution {
    // O(n) sapce, O(V+E) time
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new LinkedList<Integer>();
        if(n <= 1){
            leaves.add(0); 
            return leaves;
        }
        
        HashMap<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < n; i++)
            graph.put(i, new HashSet<Integer>());
        
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        for(int i = 0; i < n; i++)
            if(graph.get(i).size() == 1)  leaves.add(i);
        
        while(n > 2){
            List<Integer> restLeaves = new LinkedList<Integer>();
            for(int leaf : leaves){
                for(int ngb : graph.get(leaf)){
                    graph.get(leaf).remove(ngb);
                    graph.get(ngb).remove(leaf);
                    n--;
                    if(graph.get(ngb).size() == 1)
                        restLeaves.add(ngb);
                }
            }
            leaves = restLeaves;
        }
        return leaves;
    }
}