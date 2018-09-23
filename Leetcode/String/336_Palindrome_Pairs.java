class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new LinkedList<>();
        if(words == null || words.length < 2)
            return list;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++)
            map.put(words[i] , i);

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPal(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.getOrDefault(str2rvs, i) != i) {
                        list.add(Arrays.asList(map.get(str2rvs), i));
                    }
                }
                if (isPal(str2) && str2.length() != 0) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.getOrDefault(str1rvs, i) != i) { 
                        list.add(Arrays.asList(i, map.get(str1rvs)));
                    }
                }
            }
        }
        return list;
    }
    
    private boolean isPal(String s){
        int l = 0, r = s.length() - 1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;r--;
        }
        return true;
    }
    // 最优解用trie
    // https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n*k2)-java-solution-with-Trie-structure
}