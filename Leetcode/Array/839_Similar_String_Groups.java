class Solution {
    public int numSimilarGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for(String str : A)
            set.add(str);
        String[] strs = new String[set.size()];
        int idx = 0;
        for(String str : set)
            strs[idx++] = str;
        UF uf = new UF(strs);
        for(int i = 0; i < strs.length; i++){
            for(int j = i + 1; j < strs.length; j++){
                if(isSimilar(strs[i], strs[j])){
                    uf.union(strs[i], strs[j]);
                }
            }
        }
        return uf.count;
    }
    
    public boolean isSimilar(String a, String b){
        if(a == null || b == null)
            return false;
        int diff = 0;
        int i = 0;
        while(i < a.length()){
            if(a.charAt(i) != b.charAt(i))
                diff++;
            if(diff > 2)    return false;
            i++;
        }
        return diff == 2;
    }
}

class UF{
    Map<String, Integer> map = new HashMap<>();
    int count;
    public UF(String[] A){
        for(int i = 0; i < A.length; i++){
            map.put(A[i], i);
        }
        count = A.length;
    }
    
    public int root(String s){
        return map.get(s);
    }
    
    public void union(String p, String q){
        int i = root(p), j = root(q);
        if(i == j)  return;
        for(String str : map.keySet()){
            if(map.get(str) == i)
                map.put(str, j);
        }
        count--;
    }
}

// 201ms 简洁写法
class Solution {
    public int numSimilarGroups(String[] A) {
        int[] parent = new int[A.length];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int groups = A.length;
        for(int i = 0; i < A.length - 1; i++) {
            for(int j = i + 1; j < A.length; j++) {
                if(isSimilar(A[i], A[j])) {
                    int p1 = i;
                    int p2 = j;
                    while(p1 != parent[p1]) {
                        p1 = parent[p1];
                    }
                    while(p2 != parent[p2]) {
                        p2 = parent[p2];
                    }
                    if(p1 != p2) {
                        groups--;
                        parent[p2] = p1;
                    } 
                }
            }
        }
        return groups;
    }
    
    private boolean isSimilar(String word1, String word2) {
        int count = 0;
        for(int i=0; i<word1.length(); i++) {
            if(word1.charAt(i)!=word2.charAt(i)&&++count>2) {
                return false;
            }
        }
        return true;
    }
}