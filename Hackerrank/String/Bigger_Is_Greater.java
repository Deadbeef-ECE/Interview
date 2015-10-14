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
            char[] arr = sc.nextLine().toCharArray();
            if(arr.length == 1 || !getNext(arr))
                System.out.println("no answer");
            else
                System.out.println(new String(arr));
        }
    }
    
    public static boolean getNext(char[] arr){
        int i = 0;
        for(i = arr.length - 2; i > 0; i--){
            if(arr[i] < arr[i+1])
                break;
        }
        if(i == 0 && arr[i] >= arr[i+1]) return false;
        int j = 0;
        for(j = arr.length - 1; j > 0; j--){
            if(arr[j] > arr[i])
                break;
        }
        swap(arr, i, j);
        sort(arr, i);
        return true;
    }
    
    private static void sort(char[] arr, int i){
        int lo = i + 1, hi = arr.length - 1;
        while(lo < hi){
            swap(arr, lo, hi);
            lo++;
            hi--;
        }
    }
    
    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}