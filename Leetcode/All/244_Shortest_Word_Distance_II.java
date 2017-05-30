/* 题意:
 * 和243不同的是，要设计class，constructor的input是words list，其中API 
 * shortest(String w1, String w2)会调用多次  (假设word1和word2不同且都在list里)
 * 
 * solution:
 * HashMap
 */

public class WordDistance {
    private Map<String, List<Integer>> map;
    // O(n) space, O(n^2) time
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int i : l1){
            for(int j : l2){
                min = Math.min(min, Math.abs(i - j));
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");