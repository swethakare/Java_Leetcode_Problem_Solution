class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if(prev != null) {
                    prev.next = cur;
                }
                prev = cur;
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        
        return root;
    }
}
