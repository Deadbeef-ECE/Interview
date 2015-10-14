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
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        
        long diff = 0;
        for(int i = 0; i < n; i++){
            int a = matrix[i][i];
            int b = matrix[i][n-1-i];
            diff += a - b;
        }
        System.out.println(Math.abs(diff));
    }
}