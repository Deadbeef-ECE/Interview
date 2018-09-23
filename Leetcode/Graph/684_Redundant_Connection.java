class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0)
            return new int[]{};
        int n = edges.length;
        UF uf = new UF(n + 1);
        
        for(int[] e : edges){
            int u = e[0], v = e[1];
            if(uf.isConnected(u, v))    return e;
            uf.union(u, v);
        }
        return new int[]{};
    }
}

class UF{
    int[] parent;
    int[] size;
    public UF(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }
    
    public int root(int p){
        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q){
        int i = root(p), j = root(q);
        if(i == j)  return;
        if(size[i] > size[j]){
            size[i] += size[j];
            parent[j] = i;
        }else{
            size[j] += size[i];
            parent[i] = j;
        }
    }
}