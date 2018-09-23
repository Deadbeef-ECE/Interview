class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0)
            return 0;
        int n = M.length;
        UF uf = new UF(n);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(M[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}

class UF{
    int[] parent;
    int[] size;
    int count;
    public UF(int n){
        parent = new int[n];
        size = new int[n];
        count = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = i;
        }
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
        if(size[i] > size[j]){
            size[i] += size[j];
            parent[j] = i;
        }else{
            size[j] += size[i];
            parent[i] = j;
        }
        count--;
    }

    public int getCount(){
        return count;
    }
}