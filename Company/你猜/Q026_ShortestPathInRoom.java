// 26.
// 就是在一个有障碍物的方形房间里找最短路径

import java.util.LinkedList;
import java.util.Queue;

public class Q026_ShortestPathInRoom {
	static boolean[][] visited;
	static int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
	static int row;
	static int col;
	
	public static int findShortestPath(char[][] room, int x1, int y1, int x2, int y2){
		if(room[x1][y1] == 'x' || room[x2][y2] == 'x')	
			return 0;
		row = room.length; 
		col = room[0].length;
		visited = new boolean[row][col];
		visited[x1][y1] = true;
		int startPos = col * x1 + y1;
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> cnt = new LinkedList<Integer>();
		queue.add(startPos);
		cnt.add(0);
		while(!queue.isEmpty()){
			int pos = queue.poll();
			int temp = cnt.poll();
			int r = pos / col, c = pos % col;
			if(r == x2 && c == y2)
				return temp;
			// four directions
			for(int i = 0; i < 4; i++){
				int r1 = r + directions[i][0];
				int c1 = c + directions[i][1];
				if(valid(room, r1, c1)){
					visited[r1][c1] = true;
					cnt.add(temp+1);
					queue.add(col * r1 + c1);
				}
			}
		}
		return 0;
	}
	
	private static boolean valid(char[][] room, int x, int y){
		if(x < 0 || x >= row || y < 0 || y >= col)
			return false;
		if(room[x][y] == 'x' || visited[x][y])
			return false;
		return true;
	}
	
	public static void main(String[] args){
		char[][] room = {{'0','0','0','x','0'},
						 {'0','x','x','0','0'},
						 {'0','0','0','0','0'}};
		test(room, 0, 0, 0, 4);
		
		char[][] room2 = {{'0','0','0','x','0'},
				 		  {'0','x','x','0','0'},
				 		  {'0','0','0','0','0'},
				 		  {'0','0','x','0','0'}};
		test(room2, 0, 2, 0, 4);
		
		char[][] room3 = {{'0','0','0','x','0'},
		 		  		  {'0','x','x','0','0'},
		 		  		  {'0','0','x','0','0'},
		 		  		  {'0','0','x','0','0'}};
		test(room3, 0, 2, 0, 4);
	}
	
	private static void test(char[][] room, int x1, int y1, int x2, int y2){
		System.out.println("Start: ["+ x1+","+y1+"] -> End: [" + x2 +"," + y2 + "], \nRomm: ");
		int row = room.length; int col = room[0].length;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(room[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\nShortest length: " + findShortestPath(room, x1, y1, x2, y2)+"\n");
	}
}
