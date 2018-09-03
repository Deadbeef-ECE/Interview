class Solution {
    //DFS
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
    
    private int dfs(List<NestedInteger> nestedList, int level){
        int ret = 0;
        for(NestedInteger n : nestedList){
            if(n.isInteger()){
                ret += n.getInteger() * level;
            }else{
                ret += dfs(n.getList(), level + 1);
            }
        }
        return ret;
    }

    //BFS
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList<>(nestedList);
        int sum = 0, level = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                NestedInteger cur = q.poll();
                if(cur.isInteger()){
                    sum += cur.getInteger() * level;
                }else{
                    q.addAll(cur.getList());
                }
            }
            level++;
        }
        return sum;
    }
}