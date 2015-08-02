public class Solution {
    Stack<Integer> reverseOrder;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visit = new int[numCourses];
        int[] ret = new int[numCourses];
        reverseOrder = new Stack<Integer>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int[] pair : prerequisites){
            if(map.containsKey(pair[1])){
                map.get(pair[1]).add(pair[0]);
            }else{
                List<Integer> list = new LinkedList<Integer>();
                list.add(pair[0]);
                map.put(pair[1], list);
            }
        }
        
        for(int i = 0; i < numCourses; i++){
            if(visit[i] == 0){
                if(!dfs(map, visit, i))
                    return new int[0];
            }
        }
        int i = 0;
        while(!reverseOrder.isEmpty()){
            ret[i++] = reverseOrder.pop();
        }
        return ret;
    }
    
    private boolean dfs(HashMap<Integer, List<Integer>> map, int[] visit, int i){
        if(visit[i] == -1)  return false;
        if(visit[i] == 1)   return true;
        visit[i] = -1;
        if(map.containsKey(i)){
             for (int neighbor : map.get(i)) {
                if (!dfs(map, visit, neighbor)) {
                        return false;
                }
            }
        }
        visit[i] = 1;
        reverseOrder.push(i);
        return true;
    }
}