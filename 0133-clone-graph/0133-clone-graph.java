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
        if(node == null){
            return node;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        return clone(node, map);  
    }
    public Node clone(Node  node, HashMap<Integer,Node> mp){
        if(mp.containsKey(node.val)){
            return mp.get(node.val);
        }
        
        Node newnode = new Node(node.val);
        mp.put(node.val,newnode);
        for(Node child : node.neighbors){
            Node adjchild = clone(child,mp);
            newnode.neighbors.add(adjchild);
        }
        return newnode; 
    }
}