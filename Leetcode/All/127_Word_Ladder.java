public class Solution {
    // O(n) space, n is queue size
    // O(dict.size * 26*wordLen) time
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(beginWord == null || beginWord.length() == 0 || wordDict.size() == 0)
            return 0;
        wordDict.remove(beginWord);
        Queue<String> queue = new LinkedList<String>();
        int cnt = 1;
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String temp = queue.poll();
                for(int j = 0; j < temp.length(); j++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(temp.charAt(j) == ch)    continue;
                        String newStr = replace(temp, j, ch);
                        if(newStr.equals(endWord))
                            return cnt+1;
                        if(wordDict.contains(newStr)){
                            wordDict.remove(newStr);
                            queue.add(newStr);
                        }
                    }
                }
            }
            cnt++;
        }
        return 0;
    }
    private String replace(String str, int j, char ch){
        char[] arr = str.toCharArray();
        arr[j] = ch;
        return new String(arr);
    }
}