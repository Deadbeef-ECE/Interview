class Solution {
    // 和merge interval 一个思路，只不过是取最小区间而不是最大区间
    // e.g
    // merge interval: [1, 6] [2, 8] -> [1, 8]
    // 此题: [1, 6] [2, 8] -> [2, 6]
    // list可以用cnt替代从而变成O(1) space
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0)
            return 0;
        List<int[]> list = new LinkedList<>();
        Arrays.sort(points, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int[] pre = points[0];
        for(int i = 0; i < points.length; i++){
            int[] cur = points[i];
            if(cur[0] <= pre[1]){
                pre[0] = cur[0];
                pre[1] = Math.min(pre[1], cur[1]);
            }else{
                list.add(pre);
                pre = cur;
            }
        }
        list.add(pre);
        return list.size();
    }
}