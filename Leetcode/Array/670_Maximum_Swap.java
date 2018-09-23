class Solution {
    public int maximumSwap(int num) {
        char[] arr = (num + "").toCharArray();
        int maxidx = -1; int maxdigit = -1;
        int leftidx = -1; int rightidx = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > maxdigit){
                maxdigit = arr[i];
                maxidx = i;
                continue;
            }
            
            if(arr[i] < maxdigit){
                leftidx = i;
                rightidx = maxidx;
            }
        }
        
        if(leftidx == -1)   return num;
        char c = arr[rightidx];
        arr[rightidx] = arr[leftidx];
        arr[leftidx] = c;
        return Integer.parseInt(new String(arr));
    }
}