class Solution {
    // Merge Interval 思路
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList<>();
        for(List<Interval> l : schedule){
            list.addAll(l);
        }
        Collections.sort(list, (a, b) -> (a.start - b.start));
        
        Interval pre = list.get(0);
        List<Interval> merged = new ArrayList<>();
        for(int i = 1; i < list.size(); i++){
            Interval cur = list.get(i);
            if(cur.start > pre.end){
                merged.add(pre);
                pre = cur;
            }else{
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        merged.add(pre);
        if(merged.size() == 1)
            return new ArrayList<>();
        List<Interval> freeTime = new ArrayList<>();
        pre = merged.get(0);
        for(int i = 1; i < merged.size(); i++){
            int start = pre.end;
            int end = merged.get(i).start;
            Interval cur = new Interval(start, end);
            freeTime.add(cur);
            pre = merged.get(i);
        }
        return freeTime;
    }

    // 最优解法
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> ret = new ArrayList<>();
        int n = 0;
        for(List<Interval> list : schedule)
            n += list.size();
        
        int[] sT = new int[n];
        int[] eT = new int[n];
        int idx = 0;
        for(List<Interval> list : schedule){
            for(Interval it : list){
                sT[idx] = it.start;
                eT[idx] = it.end;
                idx++;
            }
        }
        
        Arrays.sort(sT);
        Arrays.sort(eT);
        
        for(int i = 0; i < n - 1; i++){
            if(eT[i] < sT[i + 1]){
                ret.add(new Interval(eT[i], sT[i + 1]));
            }
        }
        return ret;
    }
}