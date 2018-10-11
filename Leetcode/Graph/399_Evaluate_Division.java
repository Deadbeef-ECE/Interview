class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, List<Double>> weight = new HashMap<>();
        for(int i = 0; i < equations.length; i++){
            String[] eq = equations[i];
            String from = eq[0], to = eq[1];
            double w = values[i];
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
                weight.put(from, new ArrayList<>());
            }
            if(!map.containsKey(to)){
                map.put(to, new ArrayList<>());
                weight.put(to, new ArrayList<>());
            }
            map.get(from).add(to);
            map.get(to).add(from);
            weight.get(from).add(w);
            weight.get(to).add(1/w);
        }
        
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++){
            String[] q = queries[i];
            Set<String> set = new HashSet<>();
            res[i] = dfs(q[0], q[1], map, weight, set, 1.0);
        }
        return res;
    }
    
    
    private double dfs(String start, String end, Map<String, List<String>> map,
                    Map<String, List<Double>> weight, Set<String> set, double curValue){
        if(set.contains(start)) return -1.0;
        if(!map.containsKey(start)) return -1.0;
        if(start.equals(end))   return curValue;
        set.add(start);
        List<String> neighbor = map.get(start);
        List<Double> value = weight.get(start);
        double find = -1.0;
        for (int i = 0; i < neighbor.size(); i++) {
            find = dfs(neighbor.get(i), end, map, weight, set, curValue*value.get(i));
            if(find != -1.0)
                break;
        }
        set.remove(start);
        return find;
    }
}