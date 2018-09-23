class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UF uf = new UF(n);
        for(int i = 1; i < n * 2; i += 2)
            uf.union(row[i] / 2, row[i - 1] / 2);    
        return n - uf.count();
    }
}

class UF{
    int[] parent;
    int[] size;
    int cnt;
    public UF(int n){
        parent = new int[n];
        size = new int[n];
        cnt = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int count(){
        return cnt;
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
        cnt--;
    }
}