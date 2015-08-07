// 31.
// 问一个 word grid.给一个词,返回有多少个 path 可以组成所给定的词
// leetcode 212. word search II 变形

import java.util.LinkedList;
import java.util.List;

public class Q031_WordGridDFS {
	static int row;
	static int col;
	static boolean[][] visited;
	static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
	public static List<List<int[]>> find(char[][] matrix, String str){
		List<List<int[]>> ret = new LinkedList<List<int[]>>();
		if(matrix == null || matrix.length == 0)
			return ret;
		visited = new boolean[row][col];
		List<int[]> path = new LinkedList<int[]>();
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				dfs(i, j, 0, str, matrix, path, ret);
			}
		}
		return ret;
	}
	
	public static void dfs(int i, int j, int pos, String str, char[][] matrix, List<int[]> path, List<List<int[]>> ret){
		if(i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || pos > str.length())
			return;
		//System.out.println("i "+i+", j "+j+", pos "+ pos);
		if(pos < str.length() && str.charAt(pos) != matrix[i][j])
			return;
		if(pos == str.length() && !ret.contains(path)){
			List<int[]> sol = new LinkedList<int[]>(path);
			ret.add(sol);
			return;
		}
		
		visited[i][j] = true;
		int[] pair = {i,j};
		path.add(pair);
		for(int k = 0; k < 4; k++){
			int r = i + directions[k][0];
			int c = j + directions[k][1];
			dfs(r, c, pos + 1, str, matrix, path, ret);
		}
		path.remove(path.size()-1);
		visited[i][j] = false;
	}
	
	public static void main(String[] args){
		char[][] matrix = {{'e','a','t','e','a'},
						   {'a','t','a','t','t'},
						   {'e','0','e','a','e'}};
		test(matrix, "eat");
	}

	private static void test(char[][] matrix, String str){
		row = matrix.length;
		col = matrix[0].length;
		System.out.println("target is " + str+", input matrix: ");
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
		List<List<int[]>> ret = find(matrix, str);
		for(List<int[]> list: ret){
			for(int i = 0; i < list.size(); i++)
				System.out.print("["+list.get(i)[0]+","+list.get(i)[1]+"] ");
			System.out.println();
		}
	}
}
