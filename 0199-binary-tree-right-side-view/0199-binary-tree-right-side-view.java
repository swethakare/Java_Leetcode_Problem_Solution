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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ar = new ArrayList<Integer>();
        if(root == null){
            return ar;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode re = null;
        while(!q.isEmpty()){
            int size = q.size();
                    
            for(TreeNode rele : q){
                re = rele;
            }
            
            ar.add(re.val);
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }

        }
        return ar;
    }
}