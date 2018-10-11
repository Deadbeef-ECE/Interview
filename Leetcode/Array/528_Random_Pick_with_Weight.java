class Solution {
    int[] preSum;
    Random random;
    public Solution(int[] w) {
        preSum = new int[w.length];
        preSum[0] = w[0];
        for(int i = 1; i < w.length; i++)
            preSum[i] += preSum[i - 1] + w[i];
        random = new Random();
    }
    
    public int pickIndex() {
        int randNum = random.nextInt(preSum[preSum.length - 1]) + 1;
        int idx = Arrays.binarySearch(preSum, randNum);
        if(idx >= 0)
            return idx;
        return -(idx + 1);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */