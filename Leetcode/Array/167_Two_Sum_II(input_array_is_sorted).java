public class Solution {
    // O(1) space, O(n) time
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int l = 0, r = numbers.length - 1;
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                ret[0] = l + 1;
                ret[1] = r + 1;
                return ret;
            }
            if(sum > target)
                r--;
            else
                l++;
        }
        return ret;
    }
}