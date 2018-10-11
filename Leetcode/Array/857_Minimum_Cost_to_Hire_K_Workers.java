class Solution {
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[w.length][2];
        for(int i = 0; i < w.length; i++)
            workers[i] = new double[]{(double)(w[i])/q[i], (double)q[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qSum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        
        for(double[] worker : workers){
            qSum += worker[1];
            // Use minHeap but we get the Max after minused by 0
            pq.offer(-worker[1]);
            if(pq.size() > K)   qSum += pq.poll();
            if(pq.size() == K)  res = Math.min(res, qSum * worker[0]);
        }
        return res;
    }
}

// 注意到我们需要小的W/Q比，而且所有人这个比值是一样的，但是假定我们选了k个人，最后给他们的开的W/Q又一定
// 是k个人中最大的，不然有的人就满足不了最小的wage，所以W/Q是由大的数值主导。
// K个人的group 开的工资用W/Q比最大的