class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand == null || hand.length == 0 || hand.length % W != 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : hand)
            map.put(n, map.getOrDefault(n, 0) + 1);        
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());

        while(!pq.isEmpty()){
            int start = pq.poll();
            int num = map.get(start);
            if(num > 0){
                for(int i = 1; i < W; i++){
                    int next = start + i;
                    if(!map.containsKey(next) || map.get(next) < num)
                        return false;
                    else
                        map.put(next, map.get(next) - num);
                }
            }
        }
        return true;
    }
}
