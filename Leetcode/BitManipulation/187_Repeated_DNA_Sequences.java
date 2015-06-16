public class Solution {
    // O(n) space, O(n) time
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new LinkedList<String>();
        if(s.length() <= 10)
            return ret;
        HashSet<Integer> table = new HashSet<Integer>();
        HashSet<Integer> added = new HashSet<Integer>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        int num = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            num = (num << 2) + map.get(c);
            if(i >= 9){
                num &= 0xfffff;
                if(table.contains(num) && !added.contains(num)){
                    ret.add(s.substring(i-9, i+1));
                    added.add(num);
                }else{
                    table.add(num);
                }
            }
        }
        return ret;
    }
}