class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<List<NestedInteger>> q = new LinkedList<>();
        q.add(nestedList);
        int level = 1, sum = 0;
        int singleSum = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                List<NestedInteger> cur = q.poll();
                for(NestedInteger n : cur){
                    if(n.isInteger()){
                        singleSum += n.getInteger();
                    }else{
                        q.add(n.getList());
                    }
                }
            }
            sum += singleSum;
        }
        return sum;
    }
}