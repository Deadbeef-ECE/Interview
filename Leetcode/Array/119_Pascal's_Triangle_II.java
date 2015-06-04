public class Solution {
    // O(n) Space, O(n^2) time
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new LinkedList<Integer>();
        if(rowIndex < 0)    return ret;
        ret.add(1);
        for(int i = 1; i <= rowIndex; i++){
            for(int j = ret.size() - 2; j >= 0; j--){
                ret.set(j+1, ret.get(j+1)+ret.get(j));
            }
            ret.add(1);
        }
        return ret;
    }
}