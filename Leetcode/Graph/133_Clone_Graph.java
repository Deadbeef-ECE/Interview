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
        if(node == null)
            return node;

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new 
                                    HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        queue.add(node);
        map.put(node, newNode);

        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode curClone = map.get(cur);
            List<UndirectedGraphNode> neighbors = cur.neighbors;
            
            for(UndirectedGraphNode v : neighbors){
                if(!map.containsKey(v)){
                    UndirectedGraphNode copy = new UndirectedGraphNode(v.label);
                    map.put(v, copy);
                    curClone.neighbors.add(copy);
                    queue.add(v);
                }else{
                    curClone.neighbors.add(map.get(v));
                }
            }
        }
        return newNode;
    }
}