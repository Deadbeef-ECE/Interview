class Solution {
    public String rearrangeString(String s, int k) {
        if(k == 0)  return s;
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }
        // max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // if frequency is same then sort based on char
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            // sort based on max frequency
            return b[1] - a[1];
        });
        for(int i = 0; i < 26; i++){
            if(cnt[i] == 0) continue;
            pq.add(new int[] {i, cnt[i]});
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            List<int[]> list = new LinkedList<>();
            int num = Math.min(k, len);
            for(int i = 0; i < num; i++){
                if(pq.isEmpty())    return "";
                int[] pair = pq.poll();
                char c = (char)(pair[0] + 'a');
                sb.append(c);
                if(--pair[1] > 0)
                    list.add(pair);
                len--;
            }
            for(int[] pair : list)
                pq.add(pair);
        }
        return sb.toString();
    }
}

// https://leetcode.com/problems/rearrange-string-k-distance-apart/discuss/83218/Java-Solution-O(N-+-KlogK)
// https://leetcode.com/problems/rearrange-string-k-distance-apart/discuss/83251/Straightforward-solution-with-HashMap-+-PriorityQueue-+-Greedy