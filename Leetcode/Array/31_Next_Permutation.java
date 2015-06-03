public class Solution {
    // O(1) space, O(n) time
    //traversal the array to find the first decrease order
    // 1 2 3 4 5 4 3 2
    //       i
    public void nextPermutation(int[] num) {
        if(num == null || num.length <= 1)
            return;
        // 从后往前找到一个降序的较小值
        int startIndex = -1;
        for(int i = num.length - 2; i >= 0; i--){
            if(num[i] < num[i+1]){
                startIndex = i;
                break;
            }
        }
        // 找到在startIndex后面比num[startIndex]大的最小值
        // 从startIndex往后找的话要加入diff变量取最小的
        // 因为从 startIndex+1＝> n-1 是降序, 因此从后往前找的话不需要引入diff变量
        int targetIndex = 0;
        if(startIndex >= 0){
            for(int i = num.length -1; i >startIndex; i--){
                if(num[i]> num[startIndex]){
                    targetIndex = i;
                    break;
                }
            }
            swap(num, startIndex, targetIndex);
        }
        reverse(num, startIndex+1, num.length-1);
    }
    
    private void reverse(int[] num, int i, int j){
        while(i < j){
            swap(num, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}