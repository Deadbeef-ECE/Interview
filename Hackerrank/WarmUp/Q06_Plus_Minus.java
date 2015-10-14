import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int pos;
    private static int neg;
    private static int zero;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int cur = sc.nextInt();
            if(cur == 0)    zero++;
            else if(cur < 0)    neg++;
            else pos++;
        }
        double a = (double) pos / (double)n;
        double b = (double) neg / (double)n;
        double c = (double) zero/ (double)n;
        System.out.format("%.3f\n%.3f\n%.3f\n", a, b, c);
    }
}