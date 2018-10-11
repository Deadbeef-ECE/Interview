class Solution {
    int[] arr;
    Random rand;
    public Solution(int[] nums) {
        arr = nums;
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ret = arr.clone();
        for(int i = ret.length - 1; i > 0; i--){
            int j = rand.nextInt(i + 1);
            int a = ret[j];
            ret[j] = ret[i];
            ret[i] = a;
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */