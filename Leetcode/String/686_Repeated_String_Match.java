class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        int count = 1;
        while (sb.indexOf(B) == -1) {
            if (sb.length() - A.length() > B.length()) {
                return -1;
            }
            sb.append(A);
            count++;
        }
        return count;
    }

    // 牛逼解法O(1) space, O(mn) time
    public int repeatedStringMatch(String A, String B) {
        if (A == null || B == null)
            return -1;
        
        boolean[] exist = new boolean[128];
        
        // Check if the character set is the same
        for (char c : A.toCharArray()){
            exist[c] = true;
        }
        for (char c : B.toCharArray()){
            if (!exist[c]) return -1;
        }
        
        int m = A.length(), n = B.length();
        for (int i = 0; i < m; i++) {
            int j = 0;
            for (; j < n; j++) {
                // check within a loop
                if (A.charAt((i + j) % m) != B.charAt(j))
                    break;
            }
            if (j == n) {
                return (i + n) / m + ((i + n) % m == 0 ? 0 : 1);
            }
        }
        return -1;
    }
}