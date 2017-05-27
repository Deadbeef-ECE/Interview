public class Solution {
    // O(n) time, O(1) space
    public int findMinDifference(List<String> timePoints) {
        boolean[] arr = new boolean[1440];
        for(String str : timePoints){
            int idx = convert(str);
            if(arr[idx])    return 0;
            arr[idx] = true;
        }        
        int diff = Integer.MAX_VALUE;
        int pre = -1;
        int first = -1, last = -1;
        for(int i = 0; i < 1440; i++){
            if(arr[i]){
                if(first != -1) last = i;
                if(first == -1) first = i;
                if(pre != -1){
                    diff = Math.min(diff, i - pre);
                    pre = i;
                }else{
                    pre = i;
                }
            }
        }
        return Math.min(diff, 1440 - last + first);
    }
    
    public int convert(String str){
        String[] s = str.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}