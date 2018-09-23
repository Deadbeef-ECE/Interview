public class Solution {
    // HashMap:
    // O(m+n) time, O(n) space
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums1)
            map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer> list = new LinkedList<>();
        for(int n : nums2){
            if(map.containsKey(n) && map.get(n) > 0){
                list.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        int[] ret = new int[list.size()];
        int idx = 0;
        for(int n : list)
            ret[idx++] = n;
        return ret;
    }
}