class Solution {
    // 如果最频率最高的char数量超过了总长度 + 1的一半，必无解，否则必有解
    // 最优解法, greedy:
    // O(N) time, O(N) space
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0)    return "";
        int[] cnt = new int[26];
        int maxFreq = 0;
        char maxChar = S.charAt(0);
        for(int i = 0; i < S.length(); i++){
            cnt[S.charAt(i) - 'a']++;
            if(cnt[S.charAt(i) - 'a'] > maxFreq){
                maxChar = S.charAt(i);
                maxFreq = cnt[S.charAt(i) - 'a'];
            }
        }
        
        if(maxFreq > (S.length() + 1) / 2)    return "";
        char[] ret = new char[S.length()];
        int i = 0;
        while(cnt[maxChar - 'a']-- > 0){
            ret[i] = maxChar;
            i += 2;
        }
        for(int k = 0; k < 26; k++){
            while(cnt[k]-- > 0){
                if(i >= S.length()){
                    i = 1;
                }
                ret[i] = (char)(k + 'a');
                i += 2;
            }
        }
        return new String(ret);
    }

    // PriorityQueue解法:
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0)    return "";
        int[] cnt = new int[26];
        for(int i = 0; i < S.length(); i++){
            cnt[S.charAt(i) - 'a']++;
            if(cnt[S.charAt(i) - 'a'] > ((S.length() + 1) / 2))
                return "";
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(int i = 0; i < 26; i++){
            if(cnt[i] == 0) continue;
            pq.add(new int[] {i, cnt[i]});
        }
        // Use String is bad practice and we should use StringBuilder instead
        // https://stackoverflow.com/questions/18453458/string-builder-vs-string-concatenation
        String ret = "";
        while(pq.size() >= 2){
            int[] pair1 = pq.poll();
            int[] pair2 = pq.poll();
            ret += (char)(pair1[0] + 'a');
            ret += (char)(pair2[0] + 'a');
            if(--pair1[1] > 0)  pq.add(pair1);
            if(--pair2[1] > 0)  pq.add(pair2);
        }
        if(pq.size() > 0){
            int[] pair = pq.poll();
            ret += (char)(pair[0] + 'a');
        }
        return ret;
    }
}