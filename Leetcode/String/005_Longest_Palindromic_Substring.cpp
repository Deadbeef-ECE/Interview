class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.size() == 0)   return 0;
        int m[256];
        memset(m, -1, sizeof(m));
        int start = 0, cur = 0, max_len = 0;
        
        while(cur < s.size()){
            int ch = s[cur];
            if(m[ch] >= start)
                start = m[ch] + 1;
            max_len = max(max_len, cur - start + 1);
            m[ch] = cur;
            cur++;
        }
        return max_len;
    }
};