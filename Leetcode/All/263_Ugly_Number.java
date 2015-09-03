public class Solution {
	// iteration:
    public boolean isUgly(int num) {
        int div = 2 * 3 * 5;
        while(num > 0 && div > 1){
            if(num % div == 0)  
                num /= div;
            else if(num % 2 != 0 && div % 2 == 0)
                div /= 2;
            else if(num % 3 != 0 && div % 3 == 0)
                div /= 3;
            else if(num % 5 != 0 && div % 5 == 0)
                div /= 5;
        }
        return num == 1;
    }
    
	// recursion:
    public boolean isUgly(int num) {
        if(num < 1) return false;
        if(num == 1) return true;
        if(num % 2 == 0) return isUgly(num/2);
        if(num % 3 == 0) return isUgly(num/3);
        if(num % 5 == 0) return isUgly(num/5);
        return false;
    }
}