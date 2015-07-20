public class Solution {
    // O(1) space, O(1) time
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        // no overlap:
        // (abcd在efgh左边|| abcd在efgh右边) || (abcd在efgh上边||abcd在efgh下边)
        if((C < E || G < A) || (B > H || F > D))
            return area;
        int left = Math.max(E, A);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        return area - (right - left) * (top - bottom);
    }
}