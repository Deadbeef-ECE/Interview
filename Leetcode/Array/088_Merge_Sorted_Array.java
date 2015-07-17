public class Solution {
    // O(m+n) space, O(m+n) time
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        int a = m - 1;
        int b = n - 1;
        while(a >= 0 && b >= 0){
            if(nums1[a] > nums2[b])
                nums1[end--] = nums1[a--];
            else
                nums1[end--] = nums2[b--];
        }
        while(b >= 0)
            nums1[end--] = nums2[b--];
    }
}