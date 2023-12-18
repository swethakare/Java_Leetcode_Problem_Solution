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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> ar = new ArrayList<>();
        List<List<Integer>> br = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return br;
        }
        q.add(root);
        ar.add(root.val);
        while(!q.isEmpty()){
            
            int n = q.size();
            // System.out.println(ar.size());           
            ar = new ArrayList<>();
            for(int i =0;i<n;i++){
                TreeNode temp = q.poll();
                ar.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            br.add(ar);
            
        }
        return br;
      
        
    }
}