class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] table = new int[26];
        int maxFreq = 0;
        int numOfMax = 0;
        for(char c : tasks){
            table[c - 'A']++;
            if(table[c - 'A'] == maxFreq)
                numOfMax++;
            if(table[c - 'A'] > maxFreq){
                maxFreq = table[c - 'A'];
                numOfMax = 1;
            }
        }
        
        int partCnt = maxFreq - 1;
        int partLen = n - (numOfMax - 1);
        int emptySlots = partCnt * partLen;
        int availableTasks = tasks.length - numOfMax * maxFreq;
        int idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }
}