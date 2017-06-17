public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n < 0 || n > 10)  return 0;
        if(n == 0)  return 1;

        int availableNumber = 9;
        int uniqueDigits = 9;
        int sum = 10;
        for(int i = 2; i <= n; i++){
            uniqueDigits = uniqueDigits * availableNumber;
            sum += uniqueDigits;
            availableNumber--;
        }
        return sum;
    }
}