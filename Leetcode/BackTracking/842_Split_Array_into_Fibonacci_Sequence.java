class Solution {
    boolean find = false;
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new LinkedList<>();
        if(S == null || S.length() == 0) return list;
        List<Integer> path = new LinkedList<>();
        dfs(S, path, list);
        return list;
    }
    
    private void dfs(String S, List<Integer> path, List<Integer> list){
        if(find)    return;
        if(S.length() == 0 && path.size() > 2){
            list.addAll(path);
            find = true;
            return;
        }
        
        for(int i = 1; i <= S.length(); i++){
            String cur = S.substring(0, i);
            int num = 0;
            try {
                num = Integer.parseInt(cur);
            }
            catch(NumberFormatException e) {
                break;
            }
            if(cur.charAt(0) == '0' && num != 0)
                continue;
            int pre1 = path.size() < 2 ? 0 : path.get(path.size() - 1);
            int pre2 = path.size() < 2 ? num : path.get(path.size() - 2);
            if(pre1 + pre2 == num){
                path.add(num);
                dfs(S.substring(i), path, list);
                path.remove(path.size() - 1);
            }
        }
        return;
    }
}