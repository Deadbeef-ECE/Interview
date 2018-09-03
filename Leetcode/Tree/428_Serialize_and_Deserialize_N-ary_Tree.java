// ref:
// https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/discuss/151421/Java-preorder-recursive-solution-using-queue
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> list = new LinkedList<>();
        inorder(root, list);
        return String.join(",", list);
    }
    
    private void inorder(Node root, List<String> list){
        if(root == null)    return;
        list.add(String.valueOf(root.val));
        list.add(String.valueOf(root.children.size()));
        for(Node n : root.children)
            inorder(n, list);
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty())  return null;
        String[] ss = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(ss));
        return decode(q);
    }
    
    private Node decode(Queue<String> q){
        Node root = new Node();
        root.val = Integer.parseInt(q.poll());
        int size = Integer.parseInt(q.poll());
        root.children = new LinkedList<>();
        for(int i = 0; i < size; i++){
            root.children.add(decode(q));
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));