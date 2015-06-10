public class Solution {
    // O(n) space, O(nlogn) time
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        Integer[] copy = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++)
            copy[i] = nums[i];
        Arrays.sort(copy, new NumsComparator());
        StringBuilder res = new StringBuilder();
        for(Integer n : copy)
            res.append(n);
        if(res.charAt(0) == '0')    return "0";
        return res.toString();
    }
    
class NumsComparator implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        String str1 = String.valueOf(a) + String.valueOf(b);
        String str2 = String.valueOf(b) + String.valueOf(a);
        return str2.compareTo(str1);
    }
}
}