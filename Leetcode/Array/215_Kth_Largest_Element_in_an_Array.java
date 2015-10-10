public class Solution {
    // Unbounded MaxPQ brute force
    // O(n) space, O(nlogn) time
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        for(int i = 0; i < nums.length; i++)
            pq.offer(nums[i]);
        int ret = 0;
        while(k > 0){
            ret = pq.poll();
            k--;
        }
        return ret;
    }

    // Bounded PriorityQueue:
    // O(k) space, O(nlogk) time
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k + 1);
        for(int i = 0; i < nums.length; i++){
            minHeap.offer(nums[i]);
            if(minHeap.size() >= k+1){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    // Partition => [x <= p | p | x > p]:
    // O(1) space
    // O(n) time(average case), O(n^2) time(worest case)
    // why O(n) time?
    // http://www.cs.yale.edu/homes/aspnes/pinewiki/QuickSelect.html
    public int findKthLargest2(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        return getKth(nums, nums.length - k+1, 0, nums.length-1);
    }
    
    private int getKth(int[] nums, int k, int start, int end){
        int pivotal = nums[end];
        int l = start, r = end;
        while(true){
            while(nums[l] < pivotal && l < r)
                l++;
            while(nums[r] >= pivotal && l < r)
                r--;
            if(l == r)  break;
            exchg(nums, l, r);
        }
        exchg(nums, l, end);
        if(k == l+1)
            return pivotal;
        else if(k > l+1)
            return getKth(nums, k, l+1, end);
        else
            return getKth(nums, k, start, l-1);
    }
    
    private void exchg(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // Partition => [x >= p | p | x < p]:
    // O(1) space
    // O(n) time(average case), O(n^2) time(worest case)
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        return getKth(nums, 0, nums.length - 1, k);
    }
    
    private int getKth(int[] nums, int lo, int hi, int k){
        int pivotal = nums[lo];
        int i = lo, j = hi;
        while(i < j){
            while(i < j && nums[j] < pivotal){
                j--;
            }
            while(i < j && nums[i] >= pivotal){
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        if(k == j + 1){
            return pivotal;
        }else if(k < j + 1){
            return getKth(nums, lo, j - 1, k);
        }else{
            return getKth(nums, j + 1, hi, k);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}