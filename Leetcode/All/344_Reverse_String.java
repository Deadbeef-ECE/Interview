public class Solution {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while(i < j){
            char c = arr[i];
            arr[i++] = arr[j];
            arr[j--] = c;
        }
        return new String(arr);
    }
}