public class Solution {
    // space, time?
    public boolean isHappy(int n) {
        if(n <= 0)  return false;
        HashSet<Integer> set = new HashSet<Integer>();
        while(n != 1){
            int next = 0;
            int temp = n;
            while(temp != 0){
                int digit = temp % 10;
                next += digit*digit;
                temp /= 10;
            }
            if(set.contains(next)){
                return false;
            }else{
                set.add(next);
                n = next;
            }
        }
        return true;
    }
}