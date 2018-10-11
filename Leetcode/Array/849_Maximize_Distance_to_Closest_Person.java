class Solution {
    public int maxDistToClosest(int[] seats) {
        int seatIdx = -1;
        int max = 1;
        int i = 0;
        while(i < seats.length){
            if(seats[i] == 1){
                if(seatIdx == -1)   max = Math.max(max, i);
                if(seatIdx != -1)   max = Math.max(max, (i - seatIdx) / 2);
                seatIdx = i;
            }
            i++;
        }
        max = Math.max(max, i - 1 - seatIdx);
        return max;
    }
}