class Solution {
    String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                                  "....","..",".---","-.-",".-..","--","-.",
                                  "---",".--.","--.-",".-.","...","-","..-",
                                  "...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        
        Set<String> set = new HashSet<>();
        for(String s : words){
            String m = encode(s);
            set.add(m);
        }
        return set.size();
    }
    
    private String encode(String input){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            sb.append(morse[input.charAt(i) - 'a']);
        }
        return sb.toString();
    }
}