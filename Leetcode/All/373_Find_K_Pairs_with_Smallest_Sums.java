public class Solution {
    // ref: https://discuss.leetcode.com/topic/50885/simple-java-o-klogk-solution-with-explanation
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<int[]>();
        if(k == 0 || nums1.length == 0 || nums2.length == 0)
            return ret;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for(int i = 0; i < nums1.length && i < k; i++)
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            ret.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length - 1) continue;
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return ret;
    }
}