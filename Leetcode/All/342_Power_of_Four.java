public class Solution {
	// General solution
    public boolean isPowerOfFour(int num) {
        if(num % 2 != 0)    return num == 1;
        if(num % 4 != 0)    return num == 1;
        while(num > 1){
            if(num % 4 != 0)    return false;
            num /= 4;
        }
        return num == 1;
    }
    // Cheating solution
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }
    // Use radix:
    // 4 -> 0x10, 16 -> 0x100, 64 -> 0x1000
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}