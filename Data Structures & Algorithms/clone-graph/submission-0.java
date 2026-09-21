/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
       return dfs(node, new HashMap<>()); 
    }

    Node dfs(Node or, Map<Node, Node> v) {
        if(or == null) {
            return null;
        }
        if(v.containsKey(or)) {
            return v.get(or);
        }
        Node output = new Node(or.val);
        v.put(or, output);
        ArrayList<Node> n = new ArrayList<>();
        for(Node k : or.neighbors) {
            n.add(dfs(k, v));
        }
        output.neighbors = n;
        return output;
    }
}