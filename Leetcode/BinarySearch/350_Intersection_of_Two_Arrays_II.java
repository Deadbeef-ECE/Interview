public class Solution {
    // HashMap:
    // O(m+n) time, O(n) space
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0)  return nums1;
        if(nums2 == null || nums2.length == 0)  return nums2;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
        for(int i = 0; i < nums2.length; i++){
            if(!map.containsKey(nums2[i]))
                map.put(nums2[i], 1);
            else
                map.put(nums2[i], map.get(nums2[i]) + 1);
        }
        List<Integer> set = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                set.add(nums1[i]);
                if(map.get(nums1[i]) == 1)
                    map.remove(nums1[i]);
                else
                    map.put(nums1[i], map.get(nums1[i]) - 1);
            }
        }
        int[] ret = new int[set.size()];
        int i = 0;
        for(Integer n : set)
            ret[i++] = n;
        return ret;
    }
}