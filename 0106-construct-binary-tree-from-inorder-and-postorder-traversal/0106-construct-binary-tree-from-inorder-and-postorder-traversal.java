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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
        for(int i =0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        
        return buildnewtree(inorder,0,inorder.length-1,0,postorder.length-1,postorder,mp);
        
    }
    public TreeNode buildnewtree(int[] inorder, int instart, int inend, int postart, int poend, int[] postorder, Map<Integer,Integer> mp){
        
        if(instart > inend || postart > poend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[poend]);
        int inroot = mp.get(root.val);
        int leftmost = inroot - instart;
        
       root.left = buildnewtree(inorder,instart,inroot-1,postart,postart+leftmost-1,postorder,mp);
       root.right = buildnewtree(inorder,inroot+1,inend,postart+leftmost,poend-1,postorder,mp);
        
        return root;
        
    }
}