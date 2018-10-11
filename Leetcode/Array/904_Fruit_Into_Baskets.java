// Sliding Window
class Solution {
    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0)
            return 0;
        int start = 0, end = 0;
        int cnt = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        while(end < tree.length){
            int a = tree[end];
            map.put(a, map.getOrDefault(a, 0) + 1);
            end++;
            while(map.size() > 2){
                int b = tree[start];
                if(map.get(b) >= 1){
                    map.put(b, map.get(b) - 1);
                }
                if(map.get(b) == 0)
                    map.remove(b);
                start++;
            }
            res = Math.max(end - start, res);
        }
        return res;
    }
}