public class Solution {
    // O(n) space, O(n) time
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new LinkedList<Integer>();
        int num = words.length;
        int wordLen = words[0].length();
        if(s == null || s.length() < num * wordLen)
            return ret;
            
        HashMap<String, Integer> need = new HashMap<String, Integer>();
        HashMap<String, Integer> has = new HashMap<String, Integer>();
        for(String word : words){
            if(need.containsKey(word))
                need.put(word, need.get(word) + 1);
            else
                need.put(word, 1);
        }
        
        for(int i = 0; i <= s.length() - num * wordLen; i++){
            int j;
            has.clear();
            for(j = 0; j < num; j++){
                int pos = i + j * wordLen;
                String str = s.substring(pos, pos + wordLen);
                if(!need.containsKey(str)) break;
                if(has.containsKey(str)){
                    has.put(str, has.get(str) + 1);
                }else{
                    has.put(str, 1);
                }
                if(need.get(str) < has.get(str))    break;
            }
            if(j == num)    ret.add(i);
        }
        return ret;
    }
}