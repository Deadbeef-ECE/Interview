/* 题意:
 * 给一个word list, 和俩words, 返回俩words之间的最短距离, (假设word1和word2不同且都在list里)
 * E.g.:
 * words = ["practice", "makes", "perfect", "coding", "makes"].
 * word1 = “coding”, word2 = “practice”, return 3.
 * word1 = "makes", word2 = "coding", return 1.
 * 
 * solution:
 * 从左到右撸一遍
 */

public class Solution {
    // O(1) space, O(n) time 
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int dist = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1))
                p1 = i;
            if(words[i].equals(word2))
                p2 = i;
            if(p1 != -1 && p2 != -1)
                dist = Math.min(dist, Math.abs(p1-p2));
        }
        return dist;
    }
}