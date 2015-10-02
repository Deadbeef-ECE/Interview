public class Solution extends Relation {
    // O(nk) time, k is running time of knows()
    // O(1) space
    public int findCelebrity(int n) {
        int c = 0;
        for(int i = 1; i < n; i++){
            if(knows(c, i))
                c = i;
        }
        for(int i = 0; i < n; i++){
            if(i != c && (knows(c, i) || !knows(i, c)))
                return -1;
        }
        return c;
    }
}