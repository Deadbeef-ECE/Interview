public class Solution {
	/* 给一个sorted but rotated int[n], 无dups, 找minimum, 找不到返回-1 
	 * 每次分一半，必有一半是sorted，一半是unsorted, 那么min要么是在sorted那一半的第一个(第三种情况),
	 * 要么是在unsorted的部分，因此为了应对第三种情况，hi在改变的时候，hi = mid而不是mid-1. 
	 * 0, 1, 2,  4,  5, 6, 7           4, 5, 6,  7,  0, 1, 2           5, 6, 7,  0,  1, 2, 4        
	 * lo       mid       hi          lo        mid       hi           lo       mid        hi  */

	// O(1) space, O(logn) time
    public int findMin(int[] arr) {
        if(arr == null || arr.length == 0)
        	return 0;
        int lo = 0;
        int hi = arr.length-1;
        while(lo < hi){
        	int mid = lo + (hi - lo)/2;
        	// right part is sorted
        	if(arr[mid] < arr[hi]){
        		hi = mid;
        	}else{// left part is sorted
        		lo = mid + 1;
        	}
        }
        return arr[lo];
    }
}