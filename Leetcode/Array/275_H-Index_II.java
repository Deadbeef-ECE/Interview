public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int len = citations.length;
        int idx = 0;
        int lo = 0, hi = citations.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(citations[mid] + mid < len){ // search in right part
                lo = mid + 1;
            }else{
                hi = mid - 1;
                idx = len - mid;
            }
        }
        return idx;
    }
}