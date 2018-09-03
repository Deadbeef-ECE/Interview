class Solution {
    // 以special offer为外循环，如果按照needs来的话，会tle
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        return dfs(price, special, needs, map);
    }
    
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
                    Map<List<Integer>, Integer> map){
        if(map.containsKey(needs)) return map.get(needs);
        
        int localMin = getPrice(needs, price);
        for(int i = 0; i < special.size(); i++){
            List<Integer> tmp = new LinkedList<>();
            for(int j = 0; j < needs.size(); j++){
                if(needs.get(j) < special.get(i).get(j)){
                    tmp = null;
                    break;
                }
                tmp.add(needs.get(j) - special.get(i).get(j));
            }
            if(tmp != null){
                int offerPrice = special.get(i).get(needs.size());
                localMin = Math.min(localMin, offerPrice + dfs(price, special, tmp, map));
                map.put(tmp, localMin);
            }
        }
        return localMin;
        
    }
    
    private int getPrice(List<Integer> needs, List<Integer> price){
        int total = 0;
        for(int i = 0; i < needs.size(); i++){
            total += needs.get(i) * price.get(i);
        }
        return total;
    }
}