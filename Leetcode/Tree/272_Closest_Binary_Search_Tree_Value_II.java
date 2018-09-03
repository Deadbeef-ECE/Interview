/* 题意:
 * 给一个BST和一个double target, 找到k个跟target最接近的点
 *
 * Solution:
 * 遍历+ priorityQueue
 */
public class Solution {
    // 用Pair<K,V> 更为理想
    // O(n) space, O(nlogk + k) time
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        HashMap<Double, List<Integer>> map = new HashMap<Double, List<Integer>>();
        PriorityQueue<Double> minHeap = new PriorityQueue<Double>(k+1);
        
        inorder(root, target, minHeap, map);
        
        int n = 0;
        while(!minHeap.isEmpty()){
            double diff = minHeap.poll();
            List<Integer> list = map.get(diff);
            for(int i = 0; i < list.size(); i++){
                ret.add(list.get(i));
                n++;
                if(n == k)  return ret;
            }
        }
        return ret;
    }
    
    private void inorder(TreeNode root, double target, 
                        PriorityQueue<Double> minHeap, HashMap<Double, List<Integer>> map){
        if(root == null)    return;
        inorder(root.left, target, minHeap, map);
        double diff = Math.abs((double)root.val - target);
        if(map.containsKey(diff)){
            map.get(diff).add(root.val);
        }else{
            minHeap.offer(diff);
            List<Integer> list = new LinkedList<Integer>();
            list.add(root.val);
            map.put(diff, list);
        }
        inorder(root.right, target, minHeap, map);
    }

    // Deque + inorder解法
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        inorder(root, list, target, k);
        return list;
    }
    
    private void inorder(TreeNode root, LinkedList<Integer> list, double target, int k){
        if(root == null)    return;

        inorder(root.left, list, target, k);
        if (list.size() == k) {
            if (Math.abs(list.getFirst() - target) < Math.abs(root.val - target)) {
                return;
            } else {
                list.removeFirst();
            }
        }
        list.add(root.val);
        inorder(root.right, list, target, k);
    }
}