public class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> q2 = new LinkedList<Long>();
        Queue<Long> q3 = new LinkedList<Long>();
        Queue<Long> q5 = new LinkedList<Long>();
        q2.add(2L); q3.add(3L); q5.add(5L);
        Long ret = 1L;
        while(n > 1){
            if(q2.peek() < q3.peek() && q2.peek() < q5.peek()){
                ret = q2.poll();
                q2.add(2*ret); q3.add(3*ret); q5.add(5*ret);
            }else if(q3.peek() < q2.peek() && q3.peek() < q5.peek()){
                ret = q3.poll();
                q3.add(3*ret); q5.add(5*ret);
            }else{
                ret = q5.poll();
                q5.add(5*ret);
            }
            n--;
        }
        return ret.intValue();
    }
}