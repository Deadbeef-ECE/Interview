class Solution {
    public int compress(char[] chars) {
        if(chars.length < 2)    return chars.length;
        int idx = 0;
        int start = 0;
        for(int i = 0; i <= chars.length; i++){
            if(i != chars.length && chars[i] == chars[start])
                continue;
            int cnt = i - start;
            chars[idx++] = chars[start];
            start = i;
            if(cnt == 1)
                continue;
            char[] num = String.valueOf(cnt).toCharArray();
            for(char n : num)
                chars[idx++] = n;
        }
        return idx;
    }
}