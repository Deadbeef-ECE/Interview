public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(nums == null || nums.length < 4)
            return ret;
        HashMap<Integer, List<List<Integer>>> dict = new HashMap<Integer, List<List<Integer>>>();
        
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int twoSum = nums[i] + nums[j];
                List<Integer> onePair = new LinkedList<Integer>();
                onePair.add(i); 
                onePair.add(j);
                if(dict.containsKey(twoSum)){
                    List<List<Integer>> allSol = dict.get(twoSum);
                    allSol.add(onePair);
                }else{
                    List<List<Integer>> allSol = new LinkedList<List<Integer>>();
                    allSol.add(onePair);
                    dict.put(twoSum, allSol);
                }
            }
        }
        
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for(int twoSum : dict.keySet()){
            if(dict.containsKey(target - twoSum)){
                List<List<Integer>> pair1 = dict.get(twoSum);
                List<List<Integer>> pair2 = dict.get(target - twoSum);
                for(List<Integer> p1 : pair1){
                    for(List<Integer> p2 : pair2){
                        // avoid same pair
                        if(p1 == p2)    continue;
                        // avoid duplicate index(same element use twice)
                        if(p1.contains(p2.get(0)) || p1.contains(p2.get(1)))
                            continue;
                        
                        List<Integer> sol = new LinkedList<Integer>();
                        sol.add(nums[p1.get(0)]);
                        sol.add(nums[p1.get(1)]);
                        sol.add(nums[p2.get(0)]);
                        sol.add(nums[p2.get(1)]);
                        
                        Collections.sort(sol);
                        set.add(sol);
                    }
                }
            }
        }
        ret = new LinkedList<List<Integer>>(set);
        return ret;
    }
}