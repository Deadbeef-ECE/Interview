public class Solution {
    // stack
    // O(n) space, O(n) time
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<String> stack = new Stack<String>();
        for(String s : tokens){
            if(!s.equals("+") && !s.equals("-") && !s.equals("*") &&!s.equals("/")){
                stack.push(s);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                
                switch(s){
                    case "+": 
                        stack.push(String.valueOf(a + b));    
                        break;
                    case "-": 
                        stack.push(String.valueOf(b - a));    
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));    
                        break;
                    case "/": 
                        stack.push(String.valueOf(b / a));    
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
}