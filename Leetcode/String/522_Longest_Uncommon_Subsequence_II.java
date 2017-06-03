public class Solution {
    // TreeMap + sort
    // O(n^2) time, O(n) space
    public int findLUSlength(String[] strs) {
        Map<String, List<Integer>> map = new TreeMap<String, List<Integer>>(new keyComparator());
        for(int i = 0; i < strs.length; i++){
            if(!map.containsKey(strs[i]))   
                map.put(strs[i], new LinkedList<Integer>());
            map.get(strs[i]).add(i);
        }
            
        if(map.keySet().size() == 1) return -1;
        String prev = "";
        for(String str: map.keySet()){
            if(prev == ""){
                if(map.get(str).size() == 1)    return str.length();
                prev = str;
            //当前string和第一个String(最长的之一)比, 如果不是subsequence且只出现了一次, 就是LUS
            }else if(prev != "" && !isSub(prev, str)){
                if(map.get(str).size() == 1)
                    return str.length();
            }
        }
        return -1;
    }
    
    public boolean isSub(String longStr, String shortStr){
        int i = 0, j = 0;
        while(i < longStr.length() && j < shortStr.length()){
            if(longStr.charAt(i++) == shortStr.charAt(j)){
                j++;
            }
        }
        return j == shortStr.length();
    }
} 
class keyComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return -1;
        } else if (s1.length() < s2.length()) {
            return 1;
        } else {
            return s1.compareTo(s2);
        }
    }
}