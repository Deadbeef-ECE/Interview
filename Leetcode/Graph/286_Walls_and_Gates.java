public class Solution {
    // Multi-direction BFS:
    // O(n) space, O(n) time
    int row, col;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    Queue<Integer> queue;
    
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0)
            return;
        queue = new LinkedList<Integer>();
        System.out.println("I");
        row = rooms.length;
        col = rooms[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(rooms[i][j] == 0)
                    queue.add(i*col+j);
            }
        }
        
        int cnt = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int l = 0; l < size; l++){
                int cur = queue.poll();
                int r = cur / col, c = cur % col;
                for(int k = 0; k < 4; k++){
                    int x = r + dx[k];
                    int y = c + dy[k];
                    if(x < 0 || y < 0 || x >= row || y >= col)
                        continue;
                    if(rooms[x][y] == Integer.MAX_VALUE){
                        rooms[x][y] = cnt;
                        queue.add(x*col + y);
                    }
                }
            }
            cnt++;
        }
    }
}