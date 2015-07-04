public class Solution {
    // no split:
    // O(1) space, O(n) time
    public int compareVersion2(String version1, String version2) {
        int i = 0, j = 0;
        int start1, start2;
        int len1 = version1.length();
        int len2 = version2.length();
        int maxLen = Math.max(len1, len2);

        while(i <= maxLen && j <= maxLen){
            start1 = i; start2 = j;
            while(i < len1 && version1.charAt(i) != '.')    i++;
            while(j < len2 && version2.charAt(j) != '.')    j++;
            int v1 = i <= len1 ? Integer.valueOf(version1.substring(start1, i)) : 0;
            int v2 = j <= len2 ? Integer.valueOf(version2.substring(start2, j)) : 0;
            if(v1 > v2) return 1;
            if(v1 < v2) return -1;
            i++;j++; // pass '.'
        }
        return 0;
    }

    // Use split():
    // O(n) space, O(n) time
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int len = Math.max(len1, len2);

        for(int i = 0; i < len; i++){
            int digit1 = i < len1 ? Integer.valueOf(v1[i]) : 0;
            int digit2 = i < len2 ? Integer.valueOf(v2[i]) : 0;
            if(digit1 > digit2) return 1;
            if(digit1 < digit2) return -1;
        }
        return 0;
    }
}