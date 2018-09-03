class Solution {
    String ret = "";
    int minDiff = Integer.MAX_VALUE;
    public String nextClosestTime(String time) {
        char[] arr = time.toCharArray();
        int target = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3,5));
        dfs("", arr, target);
        return ret;
    }
    
    private void dfs(String s, char[] arr, int target){
        if(s.length() == 4){
            String hour = s.substring(0, 2);
            String minute = s.substring(2, 4);
            int h = Integer.parseInt(hour);
            int m = Integer.parseInt(minute);
            int cur = h * 60 + m;
            if(h < 0 || h > 23 || m < 0 || m > 59)  return;
            if(cur == target){
                int diff = 24 * 60;
                if(diff < minDiff){
                    minDiff = diff;
                    ret = hour + ":" + minute;
                }
            }
            else if(cur < target){
                int left = 24 * 60 - target;
                if(left + cur < minDiff){
                    minDiff = left + cur;
                    ret = hour + ":" + minute;
                }
            }else{
                if(cur - target < minDiff){
                    minDiff = cur - target;
                    ret = hour + ":" + minute;
                }
            }
            return;
        }
        
        for(int i = 0; i < 5; i++){
            if(arr[i] == ':') continue;
            dfs(s + arr[i], arr, target);
        }
    }
}