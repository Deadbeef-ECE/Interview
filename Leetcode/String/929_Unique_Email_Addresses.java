// O(n) space, O(n) time
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails){
            String str = compute(email);
            set.add(str);
        }
        return set.size();
    }
    
    private String compute(String e){
        String[] strs = e.split("@");
        String[] namespace = strs[0].split("\\+");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < namespace[0].length(); i++){
            char c = namespace[0].charAt(i);
            if(c != '.')
                sb.append(c);
        }
        sb.append("@");
        sb.append(strs[1]);
        return sb.toString();
    }
}