public class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ret = new LinkedList<Integer>();
        UF uf = new UF(m, n);
        for(int i = 0 ; i < positions.length; i++){
            int[] pair = positions[i];
            int x = pair[0];
            int y = pair[1];
            uf.set(x, y);
            for(int j = 0; j < 4; j++){
                int r = x + dx[j];
                int c = y + dy[j];
                uf.union(r, c, x, y);
            }
            ret.add(uf.size());
        }
        return ret;
    }
}

class UF{
    private int[] uf;
    private int m, n;
    private int size;
    public UF(int m, int n){
        this.m = m;
        this.n = n;
        uf = new int[m * n];
        Arrays.fill(uf, -1);
    }
    
    public void set(int x, int y){
        uf[n * x + y] = n * x + y;
        size += 1;
    }
    
    public void union(int x0, int y0, int x1, int y1){
        if(x0 < 0 || x0 >= m || y0 < 0 || y0 >= n)
            return;
        int i = find(x0, y0);
        int j = find(x1, y1);
        if(i == j)  return;
        if(i == -1)  return;
        size--;
        uf[i] = j;
    }
    
    public int find(int x, int y){
        if(x < 0 || x >= m || y < 0 || y >= n)
            return -1;
        int idx = x * n + y;
        while(idx >= 0 && idx != uf[idx])
            idx = uf[idx];
        return idx;
    }
    
    public int size(){
        return size;
    }
}