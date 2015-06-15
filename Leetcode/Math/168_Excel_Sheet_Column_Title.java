public class Solution {
    // O(n) space, O(log26n) time(26为底，n的对数)
    public String convertToTitle(int n) {
        StringBuilder ret = new StringBuilder();
        if(n < 1)   return ret.toString();
        while(n > 0){
            n--;
            char c = (char)((n % 26) + 'A');
            ret.insert(0, c);
            n /= 26;
        }
        return ret.toString();
    }
}