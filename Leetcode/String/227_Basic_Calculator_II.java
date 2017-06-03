public class Solution {
    // O(n) time, O(n) space
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
            
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num * 10 + (c - '0');
                
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            }
        }
        num = 0;
        for(int i : stack)
            num += i;
            
        return num;
    }
}