class Solution {
    String res = "";
    int minDiff = Integer.MAX_VALUE;
    public String nextClosestTime(String time) {
        char[] arr = time.toCharArray();
        int target = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
        StringBuilder sb = new StringBuilder();
        dfs(sb, arr, target);
        return res;
    }
    
    private void dfs(StringBuilder sb, char[] arr, int target){
        if(sb.length() == 4){
            String hour = sb.substring(0, 2);
            String minute = sb.substring(2, 4);
            int h = Integer.parseInt(hour);
            int m = Integer.parseInt(minute);
            if(h > 23 || m > 59)    return;
            int cur = h * 60 + m;
            int diff = 0;
            if(cur == target)
                diff = 24 * 60;
            else if(cur < target)
                diff = 24 * 60 - target + cur;
            else if (cur > target)
                diff = cur - target;
            
            if(diff < minDiff){
                minDiff = diff;
                res = hour + ":" + minute;
            }
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != ':'){
                sb.append(arr[i]);
                dfs(sb, arr, target);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}