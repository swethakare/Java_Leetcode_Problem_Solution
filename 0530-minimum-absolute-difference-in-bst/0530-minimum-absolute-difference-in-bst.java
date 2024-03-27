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
    ArrayList<Integer> ar = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        ar = helper(root);
        Collections.sort(ar);
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < ar.size()-1; i++){
            min = Math.min(min, ar.get(i+1) - ar.get(i));
        }
        return min;
    }
    ArrayList<Integer> helper(TreeNode root){
        if(root == null){
            return ar;
        }
        ar.add(root.val);
        helper(root.left);
        helper(root.right);
        return ar;
    }
}