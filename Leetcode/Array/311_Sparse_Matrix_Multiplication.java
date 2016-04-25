public class Solution {
    // Mathmatic method:
    // O(n^3) time, O(1) sapce
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int colB = B[0].length;
        int[][] ret = new int[rowA][colB];
        for(int i = 0; i < rowA; i++){
            for(int j = 0; j < colA; j++){
                for(int k = 0; k < colB; k++){
                    ret[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return ret;
    }
}