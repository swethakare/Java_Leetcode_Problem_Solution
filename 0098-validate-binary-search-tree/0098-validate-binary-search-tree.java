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
class Solution {
    ArrayList<Integer> ar = new ArrayList<Integer>();
    
    public boolean isValidBST(TreeNode root) {
        ar = inorder(root);
        ArrayList<Integer> br = new ArrayList<Integer>(ar);
        Collections.sort(br);
        Set<Integer> set = new HashSet<>(ar);
        if(ar.equals(br) && set.size() == ar.size()){
            return true;
        }
        return false;
    }
    ArrayList<Integer> inorder(TreeNode root){
        if(root == null){
            return ar;
        }
        inorder(root.left);
        ar.add(root.val);
        inorder(root.right);
        return ar;
    }
}