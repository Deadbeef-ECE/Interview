public class Solution {
    // O(n^2) space, O(n^2) time
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(numRows < 1)
            return ret;
        List<Integer> firstRow = new LinkedList<Integer>();
        firstRow.add(1);
        ret.add(firstRow);
        for(int i = 1; i < numRows; i++){
            List<Integer> pre = ret.get(i-1);
            int size = pre.size();
            List<Integer> thisRow = new LinkedList<Integer>();
            for(int j = 0; j <= i; j++){
                int sum = j == 0 || j == i? 1 : pre.get(j-1) + pre.get(j);
                thisRow.add(sum);
            }
            ret.add(thisRow);
        }
        return ret;
    }
}