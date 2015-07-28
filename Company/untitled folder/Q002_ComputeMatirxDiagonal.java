// 2. 
// 题目是给一个 n*m 的二维数组返回一个一维数组,这个数组包含之前数组的对角线的和。 
// e.g.:
// [1, 2, 3
//  4, 5, 6
//  7, 8, 9] return [7, 12, 15, 8, 3]

public class Q002_ComputeMatirxDiagonal {
	// @author: Lei Wang
	public static int[] getSums(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[] rst = new int[rows + cols - 1];
		
		int offset = 0;
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = 0; j < cols; j++)
				rst[offset + j] += matrix[i][j];
			offset++;
		}
		return rst;
	}
	
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4},{5,6,7,8}};//,{9,10,11,12}};
		int[] ret = getSums(matrix);
		for(int num : ret){
			System.out.print(num + " ");
		}
	}
}
