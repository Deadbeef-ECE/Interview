public class Solution {
    // O(n) space, O(n^2) time
    // No useless reverse
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "" + 0;
        int[] arr = new int[num1.length() + num2.length() - 1];
        
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                arr[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        StringBuilder ret = new StringBuilder();
        int carry = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            int sum = arr[i] + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ret.insert(0, digit);
        }
        if(carry != 0)
            ret.insert(0, carry);
        return ret.toString();
    }
    
    // O(n) space, O(n^2) time
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int [] arr = new int[n1.length() + n2.length()];
        
        for(int i = 0; i < n1.length(); i++){
            for(int j = 0; j < n2.length(); j++){
                arr[i+j] += (n1.charAt(i)-'0')*(n2.charAt(j)-'0');
            }
        }
        
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            int digit = arr[i] % 10;
            int carry = arr[i] / 10;
            
            if(i < arr.length - 1)
                arr[i+1] += carry;
            ret.insert(0, digit);
        }
        
        while(ret.charAt(0) == '0' && ret.length() > 1)
            ret.deleteCharAt(0);
        return ret.toString();
    }
}