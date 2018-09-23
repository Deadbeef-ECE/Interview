// valid number 1+3*3 法则: 
// 先trim() 
// 对于小数点: 
// (1) 前面不能有小数点或者’e’和’E’; 
// (2) '.' 在第一位的时候, len!= 1, 且后面必须是数字; 
// (3) '.' 在最后的时候, 前面必须是数字
// 对于正负号： 
// (1) 正负号不在第一位的话, 前面只能是e和E ; 
// (2) 正负号不能在最后  
// (3) 正负号后面不是0-9之间的数也不是小数点
// 对于'e' 和 'E':
// (1) 之前不能有e或E; (2) e或E不能出现在末尾; (3) 不能出现在开头

public class Solution {
    // O(1) or O(n) space: if consider the implicit space of trim()
    // O(n) time
    public boolean isNumber(String s) {
        if(s == null)   return false;
        s = s.trim();
        if(s.length() == 0) return false;
        boolean E = false;
        boolean dot = false;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '.':
                    // '.' 前不能有'.'或'e'
                    if(dot || E)    return false;
                    // '.' 在第一位的时候, len!= 1, 且后面必须是数字;
                    if(i == 0){
                        if(s.length() == 1) return false;
                        if(s.charAt(i+1) < '0' || s.charAt(i+1) > '9')  return false;
                    }
                    // '.' 在最后的时候, 前面必须是数字
                    if(i == s.length() - 1){
                        if(s.charAt(i-1) < '0' || s.charAt(i-1) > '9')  return false;
                    }
                    dot = true;
                    break;
                case '+':
                case '-':
                    // 正负号不可以在最后
                    if(i == s.length() - 1)
                        return false;
                    // 正负号不在第一位的话, 前面必须是e和E
                    if(i != 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')
                        return false;
                    // 正负号后面不是0-9之间的数也不是小数点
                    if(!(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') && s.charAt(i+1) != '.')
                        return false;
                    break;
                case 'E':
                case 'e':
                    // 之前不能有e或E，e或E不能出现在末尾，也不能出现在开头
                    if(E || i == 0 || i == s.length() - 1)
                        return false;
                    E = true;
                    break;
                default:
                    if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                        return false;
            }
        }
        return true;
    }

    public boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                numberSeen = true;
                if(eSeen)   numberAfterE = true;
            }else if(s.charAt(i) == '.'){
                if(eSeen || pointSeen)
                    return false;
                pointSeen = true;
            }else if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                if(eSeen || !numberSeen)
                    return false;
                eSeen = true;
                numberAfterE = false;
            }else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i != 0 && s.charAt(i-1) != 'e')
                    return false;
            }else{
                return false;
            }
        }
        return numberSeen && (eSeen && numberAfterE || !eSeen && !numberAfterE);
    }
}