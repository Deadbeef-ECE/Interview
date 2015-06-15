public class Solution {
    // O(n) space, O(n) time
    public static int calculate(String s) {
        int pre = 0;
        int preOp = 1;
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Character> s2 = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int j = i + 1;
                int num = c - '0';
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    int digit = s.charAt(j) - '0';
                    num = num * 10 + digit;
                    j++;
                }
                i = j - 1;
                pre = preOp == 1 ? pre + num : pre - num;
            }else if(c == '('){
                stack.push(pre);
                s2.push(preOp == 1 ? '+' : '-');
                pre = 0;
                preOp = 1;
            }else if(c == '+' || c == '-'){
                if(c == '+')    preOp = 1;
                if(c == '-')    preOp = 0;
            }else if(c == ')'){
            	char op = s2.pop();
            	pre = op == '+' ? stack.pop() + pre : stack.pop() - pre;
            }
        }
        return pre;
    }
}