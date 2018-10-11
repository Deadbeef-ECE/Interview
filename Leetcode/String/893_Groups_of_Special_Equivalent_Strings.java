class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        
        for(String str: A){
            int[] odd = new int[256];
            int[] even = new int[256];
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(i % 2 == 0){
                    even[c - 'a']++;
                }else{
                    odd[c - 'a']++;
                }
            }
            String unique = Arrays.toString(even) + " " + Arrays.toString(odd);
            set.add(unique);
        }
        
        return set.size();
    }
}