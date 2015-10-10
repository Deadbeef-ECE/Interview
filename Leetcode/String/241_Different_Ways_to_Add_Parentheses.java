public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> rst = new ArrayList<Integer>();
        for (int i = 0; i < input.length() - 1; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> first = diffWaysToCompute(input.substring(0, i));
                List<Integer> second = diffWaysToCompute(input.substring(i + 1));
                for (Integer num1: first) {
                    for (Integer num2: second) {
                        int num3 = c == '+' ? num1 + num2 : c == '-'? num1 - num2 : num1 * num2;
                        rst.add(num3);
                    }
                }
                
            }
        }
        if (rst.size() == 0)
            rst.add(Integer.parseInt(input));
        return rst;
    }
}