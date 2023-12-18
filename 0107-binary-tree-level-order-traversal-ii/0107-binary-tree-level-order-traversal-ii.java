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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // bottom up we can use the stack data structure
        List<List<Integer>> ar = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return ar;
        }
        q.add(root);
        while(!q.isEmpty()){
          
            int n = q.size();
            List<Integer> br = new ArrayList<>();
            for(int i =0;i<n;i++){
                  TreeNode temp = q.poll();
                  br.add(temp.val);
                  if(temp.left!=null){
                      q.add(temp.left);
                  }
                  if(temp.right!=null){
                      q.add(temp.right);
                  }
            }
            ar.add(br);
            
            
        }
        Collections.reverse(ar);
        return ar;
    }
}