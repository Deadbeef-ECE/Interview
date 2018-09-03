/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *          label = x; 
 *          neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    // O(n + v) space:
    // n is the maxLength of queue, which means the longest neighbor list
    // v is the number of nodes(hashMap)
    // O(v * averg in-degree) time: 
    // v is the number of nodes
    // in-dgree: one node may has been visited for serveral times
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)    return null;
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        q.add(node);

        while(!q.isEmpty()){
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode copy = map.get(cur);
            List<UndirectedGraphNode> nb = cur.neighbors;
            
            for(UndirectedGraphNode n : nb){
                if(!map.containsKey(n)){
                    map.put(n, new UndirectedGraphNode(n.label));
                    q.add(n);
                }
                copy.neighbors.add(map.get(n));
            }
        }
        return newNode;
    }
}