class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int n : G){
            set.add(n);
        }
        ListNode cur = head;
        boolean preMatch = false;
        int num = 0;
        while(cur != null){
            if(set.contains(cur.val)){
                if(preMatch == false){
                    num++;
                    preMatch = true;
                }
                cur = cur.next;
            }else{
                preMatch = false;
                cur = cur.next;
            }
        }
        
        return num;
    }
}