/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    // O(n) space, O(n^2) time
    public int maxPoints(Point[] points) {
        HashMap<Double, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < points.length; i++){
            int dup = 1;
            int vertical = 0;
            for(int j = i + 1; j < points.length; j++){
                if(points[i].x == points[j].x){
                    if(points[i].y == points[j].y){
                        dup++;
                    }else{
                        vertical++;
                    }
                }else{
                    double slope = points[j].y == points[i].y ? 0.0
                                   : (1.0*(points[i].y - points[j].y))/(points[i].x - points[j].x);
                    if(map.get(slope) != null){
                        map.put(slope, map.get(slope)+1);
                    }else{
                        map.put(slope, 1);
                    }
                }
            }
            // for not vertical line
            for(Integer cnt : map.values()){
                max = Math.max(cnt+dup, max);
            }
            // vertical line
            max = Math.max(dup+vertical, max);
            map.clear();
        }
        return max;
    }
}