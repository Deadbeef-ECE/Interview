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
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int[] table1 = new int[26];
            int[] table2 = new int[26];
            for(int j = 0; j < str1.length(); j++){
                table1[str1.charAt(j) - 'a']++;
            }
            for(int j = 0; j < str2.length(); j++){
                table2[str2.charAt(j) - 'a']++;
            }
            boolean has = false;
            for(int j = 0; j < 26; j++){
                if(table1[j] > 0 && table2[j] > 0){
                    has = true;
                    break;
                }
            }
            if(has) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}