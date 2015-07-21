public class Solution {
    // O(n) time, O(1) space
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            digits[i] = (digits[i] + 1) % 10;
            if(digits[i] == 0){
                if(i == 0){
                    int[] ret = new int[digits.length + 1];
                    ret[0] = 1;
                    return ret;
                }
            }else{
                return digits;
            }
        }
        return digits;
    }
}