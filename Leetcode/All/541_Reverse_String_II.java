public class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0, len = arr.length;
        while(i < len){
            int j = Math.min(i + k - 1, len - 1);
            reverse(arr, i, j);
            i = i + 2 * k;
        }
        return new String(arr);
    }
    
    public void reverse(char[] arr, int x, int y){
        while(x < y){
            char c = arr[x];
            arr[x++] = arr[y];
            arr[y--] = c;
        }
    }
}