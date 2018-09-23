/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int buffPtr = 0;
    int buffCnt = 0;
    char[] tmp = new char[4];
    public int read(char[] buf, int n) {
        int idx = 0;
        while(idx < n){
            if(buffPtr == 0){
                buffCnt = read4(tmp);
            }
            if(buffCnt == 0)    break;
            while(idx < n && buffPtr < buffCnt)
                buf[idx++] = tmp[buffPtr++];
            if(buffPtr == buffCnt)
                buffPtr = 0;
        }
        return idx;
    }
}