public class Solution {
    // 循环不变式
    // O(n) space, O(n) time
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new LinkedList<String>();
        if(nums == null || nums.length == 0)
            return ret;
        int start = nums[0];
        int end = nums[0];
        int i = 0;
        for(i = 0; i < nums.length - 1; i++){
            if(nums[i] + 1 == nums[i+1]) continue;
            end = nums[i];
            addRange(start, end, ret);
            start = nums[i+1];
        }
        end = nums[i];
        addRange(start, end, ret);
        return ret;
    }
    
    private void addRange(int start, int end, List<String> ret){
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        if(start != end){
            sb.append("->");
            sb.append(end);
        }
        ret.add(sb.toString());
    }
}