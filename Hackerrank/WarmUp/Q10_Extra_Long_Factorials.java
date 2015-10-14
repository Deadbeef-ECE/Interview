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
        BigInteger ret = new BigInteger("1");
        while(n > 1){
            BigInteger cur = new BigInteger(String.valueOf(n));
            ret = ret.multiply(cur);
            n--;
        }
        System.out.print(ret);
    }
}