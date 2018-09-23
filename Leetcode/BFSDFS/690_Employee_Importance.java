class Solution {
    int sum = 0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> value = new HashMap<>();
        for(Employee e : employees){
            value.put(e.id, e.importance);
            if(!graph.containsKey(e.id))
                graph.put(e.id, new LinkedList<>());
            graph.get(e.id).addAll(e.subordinates);
        }
        dfs(id, graph, value);
        return sum;
    }
    
    private void dfs(int id, Map<Integer, List<Integer>> map, Map<Integer, Integer> value){
        sum += value.get(id);
        for(int n : map.get(id))
            dfs(n, map, value);
    }
}