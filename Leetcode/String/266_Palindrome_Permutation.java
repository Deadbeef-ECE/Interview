/* 题意:
 * 给一个String s, 其permutation能否构成一个Palindrome
 * E.g.:
 * "code" -> False, "aab" -> True, "carerac" -> True.
 *
 * solution:
 * 最多一个字符出现奇数次
 */

public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] table = new int[256];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            table[ch] = table[ch] > 0 ? --table[ch] : ++table[ch];
        }
        int cnt = 0;
        for(int i = 0; i < 256; i++){
            if(table[i] != 0)    cnt++;
        }
        return cnt <= 1;
    }
}