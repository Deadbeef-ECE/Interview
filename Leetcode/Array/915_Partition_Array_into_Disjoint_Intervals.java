class Solution {
    public int partitionDisjoint(int[] A) {
        int max = A[0], preMax = max, idx = 0;
        for(int i = 1; i < A.length; i++){
            if(preMax > A[i]){
                preMax = max;
                idx = i;
            }else{
                max = Math.max(max, A[i]);
            }
        }
        return idx + 1;
    }
}