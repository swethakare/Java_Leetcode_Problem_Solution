/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    LinkedList<Integer> ar = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        ar = inorder(root);  
    }
    
    public int next() {
        int ele = ar.poll();
        
        return ele;
        
    }
    
    public boolean hasNext() {
        if(ar.isEmpty()){
            return false;
        }
        return true;
        
    }
    public LinkedList<Integer> inorder(TreeNode root){
        if(root == null){
            return ar;
        }
        inorder(root.left);
        ar.add(root.val);
        inorder(root.right);
        return ar;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */