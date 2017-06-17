public class Solution {
    int cnt;
    int[] visited;
    public int countArrangement(int N) {
        visited = new int[N+1];
        Arrays.fill(visited, -1);
        dfs(1, N);
        return cnt;
    }
    
    public void dfs(int pos, int N){
        if(pos == N + 1){
            cnt++;
            return;
        }
        
        for(int i = 1; i <= N; i++){
            if(visited[i] == -1){
                visited[i] = 1;
                if(isDivisible(i, pos)){
                    dfs(pos + 1, N);
                }
                visited[i] = -1;
            }
        }
    }
    
    public boolean isDivisible(int a, int b){
        if(a >= b && a % b == 0)
            return true;
        if(b >= a && b % a == 0)
            return true;
        return false;
    }
}