class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, 0);
        
        for(int i = 0; i < graph.length; i++){
            if(colors[i] == 0){
                if(!dfs(i, graph, colors, 1))
                    return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int u, int[][] graph, int[] color, int c){
        if(color[u] != 0)
            return color[u] == c;
        color[u] = c;
        for(int v : graph[u]){
            if(!dfs(v, graph, color, 0 - c))
                return false;
        }
        return true;
    }
}