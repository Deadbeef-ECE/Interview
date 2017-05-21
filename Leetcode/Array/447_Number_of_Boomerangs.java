public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int cnt = 0, n = points.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            // distance -> frequency
            for(int j = 0; j < n; j++){
                if(i == j)  continue;
                int[] p1 = points[i], p2 = points[j];
                int dis = (p1[0] - p2[0])*(p1[0] - p2[0]) + (p1[1] - p2[1])*(p1[1] - p2[1]);
                if(!map.containsKey(dis))
                    map.put(dis, 0);
                cnt += map.get(dis) * 2;
                map.put(dis, map.get(dis) + 1);
            }
            map.clear();
        }
        return cnt;
    }
}