class Solution {
    public int peakIndexInMountainArray(int[] A) {
        
        int l = 0, r = A.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            // peak is in the right part
            if(A[mid] > A[mid + 1] && A[mid] > A[mid - 1])
                return mid;
            if(A[mid] > A[mid + 1]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}