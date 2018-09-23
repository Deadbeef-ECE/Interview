class Solution {
    public boolean isMonotonic(int[] A) {
        if(A == null || A.length <= 1)
            return true;
        
        int diff = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] == A[i] - 1)    continue;
            if(diff == 0)   
                diff = A[i] - A[i - 1];
            if(A[i] > A[i - 1] && diff < 0)
                return false;
            if(A[i] < A[i - 1] && diff > 0)
                return false;
        }
        return true;
    }
}