public class Solution {
    // O(n) time, O(1) space
    public int maxArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int l = 0, r = height.length - 1;
        int area = Integer.MIN_VALUE;
        while(l < r){
            int h = Math.min(height[l], height[r]);
            area = Math.max(area, (r - l) * h);
            if(height[l] < height[r])   l++;
            else r--;
        }
        return area;
    }
}