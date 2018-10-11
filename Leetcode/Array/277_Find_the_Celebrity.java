public class Solution extends Relation {
    // O(nk) time, k is running time of knows()
    // O(1) space
    public int findCelebrity(int n) {
        int cand = 0;
        for(int i = 0; i < n; i++){
            if(knows(cand, i))
                cand = i;
        }
        
        for(int i = 0; i < n; i++){
            if(cand == i)   continue;
            if(!knows(i, cand) || knows(cand, i))
                return -1;
        }
        return cand;
    }
}

// It is inductive that we can find the candidate and check whether it is up to standard or not.
// 1) How do we decide the candidate?
// We are sure that if A knows B, A cannot be the celebrity while B may be, i.e., B is the candidate. 
// Since there is only one celebrity, one loop is enough to decide the candidate.
// 2) How do we check whether the candidate is up to standard?
// According to the definition of a celebrity, if !knows(i, candidate) || knows(candidate, i) exists, the candidate is not qualified.
// https://leetcode.com/problems/find-the-celebrity/discuss/144815/Logical-Thinking-with-Clear-Java-Code