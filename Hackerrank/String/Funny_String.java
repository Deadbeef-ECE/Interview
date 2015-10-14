import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            boolean f = true;
            int lo = 1, hi = str.length() - 2;
            while(lo <= hi){
                int x = lo - 1;
                int y = hi + 1;
                char leftOut = str.charAt(x);
                char leftIn = str.charAt(lo);
                char rightOut =str.charAt(y);
                char rightIn = str.charAt(hi);
                if(Math.abs(leftOut - leftIn) != Math.abs(rightOut - rightIn)){
                    f = false;
                    break;
                }
                lo++; hi--;
            }
            if(f)   System.out.println("Funny");
            else    System.out.println("Not Funny");
        }
    }
}