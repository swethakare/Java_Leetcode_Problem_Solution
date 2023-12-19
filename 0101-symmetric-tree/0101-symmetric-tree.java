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
    public boolean isSymmetric(TreeNode root) {
        return syme(root.left,root.right);        
    }
    public boolean syme(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null){
            return true;
        }
        if(r1 == null || r2 == null){
            return false;
        }
        
        boolean leftck = syme(r1.left,r2.right); 
        boolean rightck = syme(r1.right,r2.left);
        if(leftck && rightck && r1.val == r2.val){
            return true;
        }else{
            return false;
        }
        
    }
}