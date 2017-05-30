public class Solution {
    // Brute-force:
    // O(mn) time, O(1) space
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] ret = new int[findNums.length];
        Arrays.fill(ret, -1);
        for(int i = 0; i < findNums.length; i++){
            int j, k;
            for(j = 0; j < nums.length; j++){
                if(nums[j] == findNums[i])  break;
            }
            for(k = j + 1; k < nums.length; k++){
                if(nums[k] > findNums[i]){
                    ret[i] = nums[k];
                    break;
                } 
            }
        }
        return ret;
    }

    // HashMap:
    // O(mn) time, O(n) space
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] ret = new int[findNums.length];
        Arrays.fill(ret, -1);
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))    continue;
            else map.put(nums[i], i);
        }
        for(int i = 0; i < findNums.length; i++){
            if(!map.containsKey(findNums[i]))   continue;
            for(int k = map.get(findNums[i]) + 1; k < nums.length; k++){
                if(nums[k] > findNums[i]){
                    ret[i] = nums[k];
                    break;
                } 
            }
        }
        return ret;
    }
    // Hashap + stack
    // O(m+n) time, O(n) space
    // ref: https://www.youtube.com/watch?v=8P-Z7Oc8x9I
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] ret = new int[findNums.length];
        Arrays.fill(ret, -1);
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums[i]){
                map.put(stack.peek(), nums[i]);
                stack.pop();
            }
            stack.push(nums[i]);
        }
        for(int i = 0; i < findNums.length; i++){
            if(map.containsKey(findNums[i]))
                ret[i] = map.get(findNums[i]);
        }
        return ret;
    }
}