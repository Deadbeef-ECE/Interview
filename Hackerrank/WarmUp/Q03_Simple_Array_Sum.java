import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int ret = 0;
        String[] nums = sc.nextLine().split(" ");
        
        for(int i = 0; i < n; i++){
            ret += sc.nextInt();
        }
        System.out.println(ret);
    }
}