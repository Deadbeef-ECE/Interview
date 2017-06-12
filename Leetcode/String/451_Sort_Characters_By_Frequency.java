public class Solution {
    // Bucket sort:
    // O(n) time, O(n) space
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        
        List<Character>[] bucket = new List[s.length() + 1];
        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Character>();
            }
            bucket[freq].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < map.get(c); j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}