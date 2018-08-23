class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < pid.size(); i++){
            int p = ppid.get(i);
            int c = pid.get(i);
            if(!map.containsKey(p))
                map.put(p, new LinkedList<>());
            map.get(p).add(c);
        }
        List<Integer> ret = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        while(!q.isEmpty()){
            int cur = q.poll();
            ret.add(cur);
            if(map.containsKey(cur)){
                for(Integer i : map.get(cur)){
                    q.add(i);
                }
            }
        }
        return ret;
    }
}