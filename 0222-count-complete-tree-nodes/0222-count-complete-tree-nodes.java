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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        LinkedList<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int cnt = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.add(cur.left);
                    cnt++;
                }
                if(cur.right != null){
                    q.add(cur.right);
                    cnt++;
                }
            }
        }
        return cnt;
        
        
    }
}