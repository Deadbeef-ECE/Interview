class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(String str : logs){
            String[] s = str.split(":");
            int time = Integer.parseInt(s[2]);
            int id = Integer.parseInt(s[0]);
            if(s[1].equals("start")){
                stack.push(new int[]{id, time});
            }else{
                int exeTime = time - stack.pop()[1] + 1;
                res[id] += exeTime;
                if(!stack.isEmpty())
                    res[stack.peek()[0]] -= exeTime;
            }
        }
        return res;
    }
}