/*
// Definition for a Node.
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
        if (node == null) {
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, Node> mp = new HashMap<>();
        
        Node newnode = new Node(node.val);
        mp.put(node.val, newnode);
        q.add(node);
        
        while (!q.isEmpty()) {
            Node curnode = q.poll();
            
            for (Node child : curnode.neighbors) {
                if (!mp.containsKey(child.val)) {
                    Node newchild = new Node(child.val);
                    mp.put(child.val, newchild);
                    q.add(child);
                }
                mp.get(curnode.val).neighbors.add(mp.get(child.val));
            }
        }
        
        return newnode;
    }
}
