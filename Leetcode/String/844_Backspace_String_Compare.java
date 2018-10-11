class Solution {
    public boolean backspaceCompare(String S, String T) {
        if(S == null)   return T == null;
        if(T == null)   return false;
        return compute(S).equals(compute(T));
    }
    
    private String compute(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '#'){
                if(sb.length() > 0)   sb.deleteCharAt(sb.length() - 1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}