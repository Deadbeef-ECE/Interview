public class Solution {
    // Brutefore: HashMap
    // O(n) time, O(n) space
    iint max = 1;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new LinkedList<Integer>();
        helper(root, map);
        for(int n : map.keySet()){
            if(map.get(n) == max)
                list.add(n);
        }
        int[] ret = new int[list.size()];
        for(int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }
    
    public int helper(TreeNode root, Map<Integer, Integer> map){
        if(root == null)    return 0;
        int sum = root.val + helper(root.left, map) + helper(root.right, map);
        if(!map.containsKey(sum))  map.put(sum, 0);
        int freq = map.get(sum) + 1;
        map.put(sum, freq);
        if(freq > max)  max = freq;
        return sum;
    }
}