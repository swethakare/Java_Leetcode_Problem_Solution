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
    public int diameterOfBinaryTree(TreeNode root) {
        depthfinder(root);
        return max;
    }
    public int depthfinder(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = depthfinder(root.left);
        int right = depthfinder(root.right);
        max = Math.max(left+right,max); // this line ensures we get the hight at each node.
        // System.out.println(max);
        
        return 1+Math.max(left,right);
    }
}