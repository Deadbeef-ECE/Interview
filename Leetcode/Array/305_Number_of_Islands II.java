class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<>();
        UF uf = new UF(m * n + 1);
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        for(int[] pos : positions){
            int i = pos[0], j = pos[1];
            int idx = i * n + j;
            uf.set(idx);
            for(int k = 0; k < 4; k++){
                int x = i + dx[k];
                int y = j + dy[k];
                int next = x * n + y;
                if(x >= 0 && y >= 0 && x < m && y < n && uf.root(next) != (m * n)){
                    uf.union(next, idx);
                }
            }
            list.add(uf.getCount());
        }
        return list;
    }
}

class UF{
    int[] parent;
    int[] size;
    int count;
    public UF(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = n - 1;
            size[i] = 1;
        }
        count = 0;
    }
    
    public int getCount(){
        return count;
    }
    
    public void set(int n){
        parent[n] = n;
        count++;
    }
    public int root(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j)  return;
        if(size[i] < size[j]){
            size[j] += size[i];
            parent[i] = j;
        }else{
            size[i] += size[j];
            parent[j]  = i;
        }
        count--; 
    }
}