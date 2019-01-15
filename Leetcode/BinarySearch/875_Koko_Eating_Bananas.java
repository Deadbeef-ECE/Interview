class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = piles[0];
        for(int n : piles)
            max = Math.max(max, n);

        int l = 1, r = max;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int h = 0;
            for(int n : piles)
                h += (n - 1)/mid + 1;
            if(h <= H)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}