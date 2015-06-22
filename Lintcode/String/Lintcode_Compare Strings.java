public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    // O(1) space, O(n) time
    public boolean compareStrings(String A, String B) {
        // write your code here
        if(A == null || A.length() == 0)
            return (B == null || B.length() == 0);
        if(B.length() == 0 || B == null)
            return true;
        int[] map = new int[256];
        for(int i = 0; i < A.length(); i++){
            int index = A.charAt(i);
            map[index]++;
        }
        for(int i = 0; i < B.length(); i++){
            int index = B.charAt(i);
            if(--map[index] < 0)
                return false;
        }
        return true;
    }
}
