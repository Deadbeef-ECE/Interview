public class Solution {
    // DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0)
            return true;
        int[] visit = new int[numCourses];
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
            if(!doDFS(map, visit, i))
                return false;
        }
        return true;
    }
    
    private boolean doDFS(HashMap<Integer, List<Integer>> map, int[] visit, int i){
        if(visit[i] == -1)
            return false;
        if(visit[i] == 1)
            return true;
        visit[i] = -1;
        if(map.containsKey(i)){
            for(int j : map.get(i)){
                if(! doDFS(map, visit, j))
                    return false;
            }
        }
        visit[i] = 1;
        return true;
    }
}