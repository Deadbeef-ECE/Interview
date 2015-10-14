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
            String line = sc.nextLine();
            int num = cal(line);
            System.out.println(num);
        }
    }

    public static int cal(String str){
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < str.length(); i++){
            for(int l = i + 1; l <= str.length(); l++){
                String subStr = str.substring(i, l);
                String sort = sort(subStr);
                if(!map.containsKey(sort))
                    map.put(sort, 1);
                else map.put(sort, map.get(sort) + 1);
            }
        }
        int ret = 0; 
        // C(2, n) = n * (n - 1)/2
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            ret += (entry.getValue() * (entry.getValue() - 1) / 2);
        }
        return ret;
    }
    
    private static String sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}