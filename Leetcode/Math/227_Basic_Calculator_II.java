public class Solution {
    // 类似循环不变式原理
    public int calculate(String s) {
        int term = 0;
        int ret = 0;
        int status = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '+'){
                ret += term;
                term = 0;
                status = 1;
            }
            else if(c == '-'){
                ret += term;
                term = 0;
                status = 2;
            }
            else if(c == '*'){
                status = 3;
            }
            else if(c == '/'){
                status = 4;
            }
            else if(Character.isDigit(c)){
                int j = i + 1;
                int num = c - '0';
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    int digit = s.charAt(j) - '0';
                    num = num * 10 + digit;
                    j++;
                }
                i = j - 1;
                switch(status){
                    case 1:
                        term = num;
                        break;
                    case 2:
                        term = -num;
                        break;
                    case 3:
                        term *= num;
                        break;
                    case 4:
                        term /= num;
                        break;
                }
            }
        }
        return ret + term;
    }
}