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
    public int kthSmallest(TreeNode root, int k) {
        
       Kelementinorder(root);
       return ar.get(k-1);
        
    }
    ArrayList<Integer> Kelementinorder(TreeNode root){
        if(root == null){
            return ar;
        }
        Kelementinorder(root.left);
        ar.add(root.val);
        Kelementinorder(root.right);
        return ar;
    }
}