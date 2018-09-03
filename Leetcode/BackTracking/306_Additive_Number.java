class Solution {
    boolean find = false;
    public boolean isAdditiveNumber(String num) {
        if(num.isEmpty())   return false;
        List<String> list = new LinkedList<>();
        dfs(num, list);
        return find;
    }
    
    private void dfs(String num, List<String> list){
        if(num.length() == 0 && list.size() > 2){
            find = true;
            return;
        }
        for(int i = 1; i <= num.length(); i++){
            String str = num.substring(0, i);
            if(str.length() > 1 && str.charAt(0) == '0')  continue;
            String pre1 = list.size() < 2 ? "0" : list.get(list.size() - 1);
            String pre2 = list.size() < 2 ? str : list.get(list.size() - 2);
            String sum = add(pre1, pre2);
            if(sum.equals(str)){
                list.add(str);
                dfs(num.substring(i), list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private String add(String num1, String num2){
        int carry = 0;
        String ret = "";
        int len = Math.max(num1.length(), num2.length());
        for(int i = 0; i < len; i++){
            int total = carry;
            int A = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int B = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            total += A + B;
            ret = total % 10 + ret;
            carry = total / 10;
        }
        if(carry != 0)  ret = carry + ret;
        return ret;
    }
}