class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0, end = nums.length - 1;
        int idx = a > 0 ? nums.length - 1 : 0;
        while(start <= end){
            int l = compute(nums[start], a, b, c);
            int r = compute(nums[end], a, b, c);
            if(a > 0){
                if(l > r){
                    res[idx--] = l;
                    start++;
                }else{
                    res[idx--] = r;
                    end--;
                }
            }else{
                if(l > r){
                    res[idx++] = r;
                    end--;   
                }else{
                    res[idx++] = l;
                    start++;
                }
            }
        }
        return res;
    }
    
    public int compute(int x, int a, int b, int c){
        return x * x * a + x * b + c;
    }
}