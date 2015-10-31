public class Solution {
    // Union Find - Quck Union
    // O(logn) find and O(1) union
    // logn is the height of the tree
    public boolean validTree(int n, int[][] edges) {
        if(n <= 0 || edges == null)  return false;

        if(edges.length != n-1) return false;  // Unconnected part is not allowed

        int[] UF = new int[n];
        for(int i = 0; i < n; i++){
            UF[i] = i;
        }
        
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            
            if(find(UF, x) == find(UF, y))
                return false;
            UF[y] = x;
        }
        return true;
    }
    
    private int find(int[] uf, int i){
        while(i != uf[i])
            i = uf[i];
        return i;
    }
}