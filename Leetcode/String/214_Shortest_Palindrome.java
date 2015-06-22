public class Solution {
    // Cannot pass the shitest case
    // O(n) space, O(n^2) time
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String rs = new StringBuffer(s).reverse().toString();
        int length = s.length();
		int i;
        for (i = length; i >= 0; i--) {
            if (s.substring(0, i).equals(rs.substring(length - i))) {
                break;
            }
        }
        
        return rs.substring(0, length - i) + s;
    }
    // Please reference this link if you want add somthing  
    // to pass the shitest test case use the method above
// https://github.com/DeanWen/leetCodeInterview/blob/master/LeetCode/214-Shortest%20Palindrome.java

    // The similar method with 5.Longest Palindromic Substring
    public String shortestPalindrome2(String s) {
        if (s == null || s.length() <= 1)
            return s;

        String result = null;
        int len = s.length();
        int mid = len / 2;  

        for (int i = mid; i >= 1; i--) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if ((result = scanFromCenter(s, i - 1, i)) != null)
                    return result;
            } else {
                if ((result = scanFromCenter(s, i - 1, i - 1)) != null)
                    return result;
            }
        }
        return result;
    }

    private String scanFromCenter(String s, int l, int r) {
        int i = 1;
        //scan from center to both sides
        for (; l - i >= 0; i++) {
            if (s.charAt(l - i) != s.charAt(r + i))
                break;
        }
        //if not end at the beginning of s, return null 
        if (l - i >= 0)
            return null;

        StringBuilder sb = new StringBuilder(s.substring(r + i));
        sb.reverse();

        return sb.append(s).toString();
    }
}