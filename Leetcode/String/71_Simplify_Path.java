public class Solution {
    // Use split():
    // O(n) space, O(n) time
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0)
            return null;
        Stack<String> stack = new Stack<String>();
        String[] strs = path.split("/");
        for(String str : strs){
            if(str.equals(".")) continue;
            if(str.equals("..") && !stack.isEmpty())
                stack.pop();
            if(!str.equals("..") && str.length() != 0)
                stack.push(str);
        }
        
        if(stack.isEmpty()) return "/";
        StringBuilder ret = new StringBuilder();
        for(String str : stack){
            ret.append("/");
            ret.append(str);
        }
        return ret.toString();
    }

    // No split():
    // O(1) space, O(n) time
    public String simplifyPath2(String path) {
        if(path == null || path.length() == 0)
            return null;
        Stack<String> stack = new Stack<String>();
        int start = 0;
        String str = "";
        for(int i = 0; i <= path.length(); i++){
            str = "";
            if(i < path.length() && path.charAt(i) != '/')
                continue;
            str = path.substring(start, i);
            start = i+1;
            if(str.equals(".")) continue;
            if(str.equals("..") && !stack.isEmpty())    
                stack.pop();
            if(!str.equals("..") && str.length() != 0)
                stack.push(str);
        }
        
        if(stack.isEmpty()) return "/";
        StringBuilder ret = new StringBuilder();
        for(String s : stack){
            ret.append("/");
            ret.append(s);
        }
        return ret.toString();
    }
}