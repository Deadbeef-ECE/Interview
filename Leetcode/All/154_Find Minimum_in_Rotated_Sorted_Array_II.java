public class Solution {
    // O(1) space, O(logn) avg time, O(n) worest case
    public int findMin(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        int lo = 0;
        int hi = arr.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            // right part is sorted
            if(arr[mid] < arr[hi])
                hi = mid;
            // left part is sorted or cannot determine
            else{
                if(arr[mid] == arr[hi]){
                    hi--;   continue;
                }
                lo = mid + 1;
            }
        }
        return arr[lo];
    }
}