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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    
    }
    public int helper(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            ans = ans + sum + root.val;
            return ans;
        }
        sum += root.val;
        if(root.left != null){
            helper(root.left, sum * 10);
        }        
        if(root.right != null){
            helper(root.right, sum*10);
        }
        return ans;
    }
}
        
        