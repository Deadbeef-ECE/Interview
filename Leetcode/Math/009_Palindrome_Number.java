public class Solution {
    // O(1) space, O(1) time (integer length/size is constant)
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int probe = 1;
        while(probe <= x/10){
            probe *= 10;
        }
        while(x > 0){
            int lowest = x % 10;
            int highest = x / probe;
            if(lowest != highest)   return false;
            x = (x - highest * probe)/10;
            probe /= 100;
        }
        return true;
    }
}