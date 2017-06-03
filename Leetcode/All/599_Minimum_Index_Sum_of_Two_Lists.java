public class Solution {
    // HashMap + HashSet
    // O(n) space, O(n) time
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashSet<String> common = new HashSet<String>();
        
        for(int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        
        for(int i = 0; i < list2.length; i++){
            if(map.containsKey(list2[i])){
                map.put(list2[i], map.get(list2[i]) + i);
                common.add(list2[i]);
            }
        }
        
        List<String> sol = new LinkedList<String>();
        int sum = Integer.MAX_VALUE;
        for(String com : common){
            if(map.get(com) < sum){
                sum = map.get(com);
                sol.clear();
                sol.add(com);
            }else if(map.get(com) == sum){
                sol.add(com);
            }
        }
        
        String[] ret = new String[sol.size()];
        for(int i = 0; i < sol.size(); i++)
            ret[i] = sol.get(i);
        return ret;
    }
}