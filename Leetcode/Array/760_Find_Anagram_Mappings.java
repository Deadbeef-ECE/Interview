class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] res = new int[A.length];
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for(int i = 0; i < B.length; i++){
            if(!map.containsKey(B[i]))
                map.put(B[i], new LinkedList<>());
            map.get(B[i]).add(i);
        }
        
        for(int i = 0; i < A.length; i++)
            res[i] = map.get(A[i]).remove();
        return res;
    }
}