class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length)
            return false;
        UF uf = new UF(pairs);
        for(String[] pair : pairs)
            uf.union(pair[0], pair[1]);

        for(int i = 0; i < words1.length ; i++){
            if(words1[i].equals(words2[i]))
                continue;
            if(!uf.isConnected(words1[i], words2[i]))
                return false;
        }
        return true;
    }
}

class UF{
    Map<String, Integer> map;
    public UF(String[][] pairs){
        map = new HashMap<>();
        int i = 0;
        for(String[] pair : pairs){
            String p1 = pair[0], p2 = pair[1];
            if(!map.containsKey(p1))
                map.put(p1, i++);
            if(!map.containsKey(p2))
                map.put(p2, i++);
        }
    }
    public boolean isConnected(String p, String q){
        if(!map.containsKey(p) || !map.containsKey(q))
            return false;
        return root(p) == root(q);
    }
    public int root(String p){
        return map.get(p);
    }
    
    public void union(String p, String q){
        int i = root(p), j = root(q);
        if(i == j)  return;
        for(String str : map.keySet()){
            if(map.get(str) == i)
                map.put(str, j);
        }
    }
}

// 基本上最优解
class Solution {
    Map<String, String> parent;
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length)
            return false;
        parent = new HashMap<>();
        
        for(String[] s : pairs)
            union(s[0], s[1]);
        
        for(int i = 0; i < words1.length; i++){
            String s1 = words1[i], s2 = words2[i];
            if(s1.equals(s2))
                continue;
            if(!findParent(s1).equals(findParent(s2)))
                return false;
        }
        return true;
    }
    private String findParent(String p){
        if(parent.containsKey(p)){
            return findParent(parent.get(p));
        }
        return p;
    }
    private void union(String p, String q){
        String s1 = findParent(p);
        String s2 = findParent(q);
        if(!s1.equals(s2))
            parent.put(s1, s2);
    }
}