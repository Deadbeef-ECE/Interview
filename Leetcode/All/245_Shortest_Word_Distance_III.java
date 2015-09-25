/* 题意:
 * 和243不同的是, word1和word2可以相同, 但必须是list里不同的两个word
 */

public class Solution {
    // Two pointer solution:
    // O(1) space, O(n) time
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0)
            return 0;
        int p1 = -1;
        int p2 = -1;
        int dist = Integer.MAX_VALUE;

        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1))
                p1 = i;
            if(words[i].equals(word2)){
                if(word1.equals(word2) && p1 == i)
                    continue;
                p2 = i;
            }
            if(p1 != -1 && p2 != -1 && p1 != p2)
                dist = Math.min(dist, Math.abs(p1 - p2));
        }
        return dist;
    }

    // HashMap solution
    // O(n) space, O(l^2) time
    public int shortestWordDistance(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
        if(word1.equals(word2) && map.get(word1).size() == 1)
            return 0;
            
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        
        for(int i : l1){
            for(int j : l2){
                if(i != j)
                    min = Math.min(min, Math.abs(i - j));
            }
        }
        return min;
    }
}