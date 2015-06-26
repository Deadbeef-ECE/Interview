public class Solution {
    // 循环不变式
    // O(n) space, O(n) time
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new LinkedList<String>();
        if(nums == null || nums.length == 0)
            return ret;
        int start =  nums[0];
        int end = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                end = nums[i];
                continue;
            }
            String str = generateRange(start, end);
            ret.add(str);
            start = nums[i];
            end = start;
        }
        String str = generateRange(start, end);
        ret.add(str);
        return ret;
    }
    
    private String generateRange(int start, int end){
        StringBuilder str = new StringBuilder();
        str.append(start);
        if(start != end){
            str.append("->");
            str.append(end); 
        }
        return str.toString();
    }
}