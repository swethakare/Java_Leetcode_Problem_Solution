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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        ArrayList<Integer> br = new ArrayList<Integer>();
        ar = helper(root1,ar);
        br = helper(root2,br);

        if(ar.equals(br)){
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> ar){
        if(root == null){
            return ar;
        }
        if(root.left == null && root.right == null){
            ar.add(root.val);
            return ar;
        }
        helper(root.left,ar);
        helper(root.right,ar);
        return ar;
        
    }
}