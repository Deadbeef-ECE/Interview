/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private Queue<Character> queue = new LinkedList<Character>();
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int cnt = 0;
        int left = queue.size();
        // maybe n is less than 4 and left also
        int get = Math.min(n, left);
        for(; cnt < get; cnt++)
            buf[cnt] = queue.poll();
            
        // if not enough only getting from the queue
        while(cnt < n){
            int read = read4(buffer);
            int temp = Math.min(read, n - cnt);
            for(int i = 0; i < temp; i++)
                buf[cnt + i] = buffer[i];
            cnt += temp;
            // if we won't use all of chars from read4 this time
            while(temp < read)  
                queue.add(buffer[temp++]);
            if(read < 4)    break;
        }
        return cnt;
    }
}