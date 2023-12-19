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
    int max = 0;
    public boolean isBalanced(TreeNode root) {
        if(checkheight(root) == -1){
            return false;
        }else{
            return true;
        }
    }
    public int checkheight(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int lh = checkheight(root.left);
        if(lh ==-1){
            return -1;
        }
        int rh = checkheight(root.right);
        if(rh == -1){
            return -1;
        }
        if(Math.abs(lh-rh)>1){
            return -1;
        }
        return 1+Math.max(rh,lh);
    }
}