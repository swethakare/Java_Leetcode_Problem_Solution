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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> br = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return br;
        }
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> ar = new ArrayList<>();
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
            // System.out.println(ar);
            double sum = 0.0;
            double avg = 0.0;
            for(int i =0;i<ar.size();i++){
                sum = sum + ar.get(i); 
            }
            avg = sum / ar.size();
            br.add(avg);
        }
        return br;  
    }
}