public class Solution {
    // O(n) space, O(n) time
    public boolean isValid(String s) {
        if(s.length() <= 1 || s == null)
            return false;
        Stack<Character> stack = new Stack<Character>();
        char temp;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty())
                    return false;
                temp = stack.pop();
                if(s.charAt(i) == ')' && temp != '(')
                    return false;
                if(s.charAt(i) == ']' && temp != '[')
                    return false;
                if(s.charAt(i) == '}' && temp != '{')
                    return false;
            }
        }
        return stack.size() == 0;
    }
}