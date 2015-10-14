import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] time = new int[3];
        time[0] = Integer.parseInt(str.substring(0, 2));
        time[1] = Integer.parseInt(str.substring(3, 5));
        time[2] = Integer.parseInt(str.substring(6, 8));
        String zone = str.substring(8);
        
        // 12:34:32PM 2:34:32PM
        if(zone.equals("PM") && time[0] != 12)
                time[0] += 12;
        // 12:00:00AM 
        if(zone.equals("AM") && time[0] == 12)
                time[0] -= 12;
        
        String ret = "";
        for(int i = 0; i < 3; i++){
            if(time[i] < 10)
                ret += "0";
            ret += time[i];
            if(i < 2)
                ret += ":";
        }
        System.out.println(ret);
    }
}