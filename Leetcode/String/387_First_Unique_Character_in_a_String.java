class Solution {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}

//最优解了解一下
class Solution {
    public int firstUniqChar(String s) {
        int res = 0, min = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++){
            int idx = s.indexOf(c);
            if (idx != -1 && idx == s.lastIndexOf(c) && idx < min)
                min = idx;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}