public class Solution {
    // DP + Largest Rectangle in Histogram(Leetcode No.84)
    // O(n^2) space, O(n^2) time
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] table = new int[row][col+1];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '0'){
                    table[i][j] = 0;
                }else{
                    table[i][j] = i == 0 ? 1 : table[i-1][j]+1;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < row; i++){
            int tempArea = maxRectangle(table[i]);
            max = Math.max(max, tempArea);
        }
        return max;
    }
    // 84 Largest Rectangle in Histogram Solution
    private int maxRectangle(int[] h){
        int len = h.length;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int max = 0;
        while(i < len){
            if(stack.isEmpty() || h[i] > h[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int start = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h[start] * width);
            }
        }
        return max;
    }
}