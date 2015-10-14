import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int retDay = sc.nextInt();
        int retMon = sc.nextInt();
        int retYear= sc.nextInt();
        int expDay = sc.nextInt();
        int expMon = sc.nextInt();
        int expYear = sc.nextInt();
        if(expYear < retYear){
            System.out.print(10000);  
            return;
        }

        if(expYear == retYear && expMon < retMon){
            System.out.print(500 * (retMon - expMon));
            return;
        }
        if(expMon == retMon && expYear == retYear && expDay < retDay){
            System.out.print(15 * (retDay - expDay));
            return;
        }
        System.out.print(0);
        return;
    }
}