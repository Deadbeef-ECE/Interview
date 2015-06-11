public class Solution {
    // O(n) space, O(n) time
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new LinkedList<String>();
        for(int i = 0; i < nums.length && lower <= upper && nums[i] <= upper; i++){
            if(nums[i] > lower){
                String interval = generate(lower, nums[i]-1);
                lower = nums[i]+1;
                ret.add(interval);
            }else if(nums[i] == lower){
                lower++;
            }
        }
        if(lower <= upper){
            String interval = generate(lower, upper);
            ret.add(interval);
        }
        return ret;
    }
    
    private String generate(int start, int end){
        StringBuilder str = new StringBuilder();
        str.append(start);
        if(start != end){
            str.append("->");
            str.append(end);
        }
        return str.toString();
    }
}