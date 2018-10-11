class Solution {
    boolean hasCycle;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] arr = new int[N + 1];
        hasCycle = false;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p : dislikes){
            int u = p[0];
            int v = p[1];
            if(!map.containsKey(u))
                map.put(u, new LinkedList<>());
            if(!map.containsKey(v))
                map.put(v, new LinkedList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        for(int i = 1; i <= N; i++){
            if(arr[i] == 0){
                dfs(1, 1, arr, map);
            }
        }
        return !hasCycle;
    }
    
    private void dfs(int cur, int val, int[] arr, Map<Integer, List<Integer>> map){
        if(hasCycle)    return;
        if(arr[cur] == val)
            return;
        if(arr[cur] == 0 - val){
            hasCycle = true;
            return;
        }
        arr[cur] = val;
        if(map.containsKey(cur)){
            for(int v : map.get(cur)){
                dfs(v, 0 - val, arr, map);    
            }
        }
    }
}

// Leetcode accept的最优解, 但这种解法不对，例
// 4 [[2,3],[2,4],[3,4]]
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] arr = new int[N + 1];
        Arrays.fill(arr, 0);
        arr[1] = 1;
        for (int[] p : dislikes) {
            if (arr[p[0]] == 0) {
                arr[p[0]] = -1 * arr[p[1]];
            } else if (arr[p[0]] == 1) {
                if (arr[p[1]] == 1) {
                    return false;
                }
                arr[p[1]] = -1;
            } else if (arr[p[0]] == -1) {
                if (arr[p[1]] == -1) {
                    return false;
                }
                arr[p[1]] = 1;
            }
        }
        return true;
    }
}