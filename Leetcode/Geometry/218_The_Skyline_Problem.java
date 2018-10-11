class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] h : buildings){
            height.add(new int[]{h[0], -h[2]});
            height.add(new int[]{h[1], h[2]});
        }
        
        Collections.sort(height, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        
        int pre = 0;
        
        for(int[] h : height){
            if(h[1] < 0)
                pq.offer(-h[1]);
            else
                pq.remove(h[1]);
            int cur = pq.peek();
            if(pre != cur){
                res.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return res;
    }
}