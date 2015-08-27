/* 题意:
 * 给一个String[], 将里面的有相同pattern(caesar cipher) 的字符组合起来 
 * E.g. given: ["abc", "bcd", "acef",  * "xyz", "az", "ba", "a", "z"], 
 * Return: [ [“abc","bcd","xyz"], ["az","ba"],  ["acef"],  ["a","z"]] 
 * 
 * Solution:
 * 提取offset ＝ str.charAt(0) - ‘a’, feature += (各字母 - offset + 26)%26
 */

public class Solution {
    // O(n) space, O(nk) time, k is average length of strings.
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> ret = new LinkedList<List<String>>();
        
        for(String str : strings){
            String feature = getFeature(str);
            if(!map.containsKey(feature)){
                List<String> list = new LinkedList<String>();
                map.put(feature, list);
            }
            map.get(feature).add(str);
        }
        
        for(String str : map.keySet()){
            List<String> list = map.get(str);
            Collections.sort(list);
            ret.add(list);
        }
        return ret;
    }
    
    private String getFeature(String str){
        int offset = str.charAt(0) - 'a';
        String feature = "";
        for(int i = 0; i < str.length(); i++){
            char c = (char)((str.charAt(i) - offset + 26) % 26); 
            feature += c;
        }
        return feature;
    }
}