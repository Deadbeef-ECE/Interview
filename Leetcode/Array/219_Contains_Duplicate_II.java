public class Solution {
    // O(n) space, O(n) time 
    // worst time example:
    // [1,2,3,4,5,6,7,1]  k = 8
    // space: 
    // the number of distinct numbers num
    // average list len(avg = n/num) then num * n/num = n

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 1)
            return false;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer> list = map.get(nums[i]);
                for(int index : list){
                    if(Math.abs(index - i) <= k)
                        return true;
                }
                list.add(i);
            }else{
                List<Integer> list = new LinkedList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        return false;
    }
}