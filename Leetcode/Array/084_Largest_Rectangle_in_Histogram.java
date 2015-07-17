public class Solution {
    // O(n) space, O(1) time
    public int largestRectangleArea(int[] h) {
        if(h == null || h.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while(i < h.length){
            // 递增push
            if(stack.isEmpty() || h[i] > h[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int start = stack.pop();
                int width = stack.isEmpty() ? i:i - stack.peek() - 1;
                max = Math.max(max, h[start]*width);
            }
        }
        while(!stack.isEmpty()){
            int start = stack.pop();  
            int width = stack.empty() ? h.length : h.length - stack.peek() - 1;
            max = Math.max(max, h[start] * width);        
        }
        return max;
    }

    // 在input后面加个0，可以把第二个while合并进第一个while中
    // O(n) space, O(1) time
    public int largestRectangleArea2(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int[] h = new int[height.length+1];
        h = Arrays.copyOf(height, height.length+1);
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while(i < h.length){
            // 递增push
            if(stack.isEmpty() || h[i] > h[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int start = stack.pop();
                // 1 3 4 5 2 1   (p = stack.peek(), s = start)
                //     p s i
                // 1 3 4 5 2 1
                //   p s   i
                
                int width = stack.isEmpty() ? i:i - stack.peek() - 1;
                max = Math.max(max, h[start]*width);
            }
        }
        return max;
    }
}