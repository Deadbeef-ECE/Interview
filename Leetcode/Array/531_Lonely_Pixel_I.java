public class Solution {
    // O(m+n) space, O(mn) time
    public int findLonelyPixel(char[][] picture) {
        if(picture == null || picture.length == 0)
            return 0;
        int m = picture.length, n = picture[0].length;
        int[] rowMarker = new int[m], colMarker = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 'B'){
                    rowMarker[i]++;
                    colMarker[j]++;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 'B' && rowMarker[i] == 1 && colMarker[j] == 1)
                    count++;
            }
        }
        return count;
    }
}