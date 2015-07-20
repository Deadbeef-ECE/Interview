public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        double ret;
        // odd
        if(len % 2 != 0){
            ret = findKthElement(nums1, 0, nums2, 0, len/2 + 1);
        }else{//even
            ret = (findKthElement(nums1, 0, nums2, 0, len/2)
            + findKthElement(nums1, 0, nums2, 0, len/2 + 1))/(2.0);
        }
        return ret;
    }
    
    private int findKthElement(int[] nums1, int start1, int[] nums2, int start2, int k){
        int len1 = nums1.length, len2 = nums2.length;
        if(start1 >= len1)
            return nums2[start2+k-1];
        if(start2 >= len2)
            return nums1[start1+k-1];
        if(k == 1)
            return Math.min(nums1[start1], nums2[start2]);
        int mid = k / 2 - 1;
        
        int valueInA = start1 + mid >= len1 ? Integer.MAX_VALUE : nums1[start1 + mid];
        int valueInB = start2 + mid >= len2 ? Integer.MAX_VALUE : nums2[start2 + mid];
        
        if(valueInA < valueInB){
            //A小了，A走一点
            return findKthElement(nums1, start1 + k/2, nums2, start2, k - k/2);
        }else{
            //B小了，B走一点
            return findKthElement(nums1, start1, nums2, start2 + k/2, k - k/2);
        }
    }
}