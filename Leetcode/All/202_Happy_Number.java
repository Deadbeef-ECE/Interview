public class Solution {
    // NiuBi Solution
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getSquareSum(slow);
            fast = getSquareSum(fast);
            fast = getSquareSum(fast);
        } while(slow != fast);

        return slow == 1;
    }
    
    private int getSquareSum(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    
    // space, time?
    public boolean isHappy(int n) {
        if(n <= 0)  return false;
        HashSet<Integer> set = new HashSet<Integer>();
        while(n != 1){
            int next = 0;
            int temp = n;
            while(temp != 0){
                int digit = temp % 10;
                next += digit * digit;
                temp /= 10;
            }
            if(set.contains(next)){
                return false;
            set.add(next);
            n = next;
        }
        return true;
    }
}