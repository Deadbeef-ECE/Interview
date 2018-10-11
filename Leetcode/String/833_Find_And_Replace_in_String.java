// indexes 并不一定是sorted
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int[] match = new int[S.length()];
        Arrays.fill(match, -1);
        for(int i = 0; i < indexes.length; i++){
            if(S.startsWith(sources[i], indexes[i]))
                match[indexes[i]] = i; 
        }
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < S.length()){
            if(match[i] == -1){
                sb.append(S.charAt(i++));
            }else{
                sb.append(targets[match[i]]);
                i += sources[match[i]].length();
            }
        }
        return sb.toString();
    }
}

// PQ 愚蠢解法
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.idx - b.idx));
        for(int i = 0; i < indexes.length; i++)
            pq.offer(new Node(indexes[i], sources[i], targets[i]));

        int preEnd = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int idx = cur.idx;
            int len = cur.u.length();
            sb.append(S.substring(preEnd, idx));
            boolean valid = false;
            if(S.substring(idx, idx + len).equals(cur.u)){
                //System.out.println(sources[i]);
                sb.append(cur.v);
                valid = true;
            }
            preEnd = idx;
            if(valid)
                preEnd += len;
        }
        sb.append(S.substring(preEnd, S.length()));
        return sb.toString();
    }
}

class Node{
    int idx;
    String u;
    String v;
    public Node(int index, String sr, String ta){
        this.idx = index;
        this.u = sr;
        this.v = ta;
    }
}