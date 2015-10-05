public class Solution {
	// while loop solution
	// O(1) space O(log  num) time
	//                 10
    public int addDigits(int num) {
        while(num > 9)
            num = num/10 + num % 10;
        return num;
    }

    //Recursion solution
    public int addDigits(int num) {
        if(num <= 9) return num;
        return addDigits(num/10 + num%10);
    }

    // One line solution
    public int addDigits(int num) {
        return num - ((num-1)/9)*9;
    }

    public int addDigits(int num) {
        return (num-1)%9 + 1;
    }
}