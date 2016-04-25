public class Solution {
    Stack<Integer> reversePostOrder;
    boolean hasCycle;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        reversePostOrder = new Stack<Integer>();
        hasCycle = false;
        int[] ret = new int[numCourses];
        int[] visited = new int[numCourses];
        Map<Integer, List<Integer>> map = buildGraph(numCourses, prerequisites);
        
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                dfs(i, map, visited);
            }
        }
        
        if(hasCycle)    return new int[0];
        int j = 0;
        while(!reversePostOrder.isEmpty()){
            ret[j++] = reversePostOrder.pop();
        }
        return ret;
    }
    
    private void dfs(int i, Map<Integer, List<Integer>> map, int[] visited){
        visited[i] = -1;
        if(map.containsKey(i)){
            for(int n : map.get(i)){
                if(hasCycle) return;
                if(visited[n] == -1){
                    hasCycle = true;
                    return;
                }
                if(visited[n] == 0)
                    dfs(n, map, visited);
            }
        }
        reversePostOrder.push(i);
        visited[i] = 1;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int[] pair : prerequisites){
            int cur = pair[0];
            int pre = pair[1];
            if(!map.containsKey(pre))
                map.put(pre, new LinkedList<Integer>());
            map.get(pre).add(cur);
        }
        return map;
    }
}