/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int num = 0;
        
        while(num < n){
            int temp = read4(buffer);
            int needToCopy = Math.min(temp, n - num);
            for(int i = 0; i < needToCopy; i++)
                buf[num + i] = buffer[i];
            num += needToCopy;
            if(needToCopy < 4)
                break;
        }
        return num;
    }
}