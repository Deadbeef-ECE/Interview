public class Solution {
    // Binary Indexed Tree
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        if (nums.length == 0) return ret;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < sorted.length; i++)
            map.put(sorted[i], i + 1);

        BIT tree = new BIT(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            ret.addFirst(tree.getSum(map.get(nums[i])));
            System.out.println(ret.peek());
            tree.update(map.get(nums[i]) + 1, 1);
        }
        return ret;    
    }
}

class BIT{
    int[] aux;
    public BIT(int[] arr){
        aux = new int[arr.length + 1];
    }
    
    public void update(int index, int val){
        assert(index > 0);
        while(index < aux.length){
            aux[index] += val;
            index += index & (-index);
        }
    }
    
    public int getSum(int index){
        assert(index > 0);
        int sum = 0;
        while(index != 0){
            sum += aux[index];
            index -= index & (-index);
        }
        return sum;
    }
}