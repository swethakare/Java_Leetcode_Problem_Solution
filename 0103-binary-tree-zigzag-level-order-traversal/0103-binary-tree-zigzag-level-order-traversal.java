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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue <TreeNode> q = new LinkedList<>();
        List<List<Integer>> br = new ArrayList<>();
        if(root == null){
            return br;
        }
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            List<Integer> ar = new ArrayList<>();
            int n = q.size();
            level ++;
            for(int i = 0;i < n;i++){
                TreeNode temp = q.poll();
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
                ar.add(temp.val);
            }
            if(level%2 == 0){// when level is even reverse it to print 
                Collections.reverse(ar);
                br.add(ar);
            }else{
                br.add(ar);
            }
        }
        return br;
    }
}