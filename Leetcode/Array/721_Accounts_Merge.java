class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ret = new LinkedList<>();
        if(accounts == null || accounts.size() == 0)
            return ret;
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for(List<String> list : accounts){
            for(int i = 1; i < list.size(); i++){
                owner.put(list.get(i), list.get(0));
                parents.put(list.get(i), list.get(1));
            }
        }
        
        for(List<String> list : accounts){
            String p = find(parents, list.get(1));
            for(int i = 2; i < list.size(); i++){
                parents.put(find(parents, list.get(i)), p);
            }
        }
        
        for(List<String> list : accounts){
            String p = find(parents, list.get(1));
            if(!unions.containsKey(p))
                unions.put(p, new TreeSet<>());
            for(int i = 1; i < list.size(); i++)
                unions.get(p).add(list.get(i));
        }
        
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            //Collections.sort(emails);
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    
    private String find(Map<String, String> parents, String p){
        if(parents.get(p) == p) return p;
        return find(parents, parents.get(p));
    }
}