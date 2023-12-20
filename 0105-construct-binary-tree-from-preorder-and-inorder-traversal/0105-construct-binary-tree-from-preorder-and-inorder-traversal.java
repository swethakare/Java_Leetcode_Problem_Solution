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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int instart = 0;
        int inend = inorder.length-1;
        int prestart = 0;
        int preend = preorder.length-1;
        
        return buildtreenow(preorder,prestart,preend,inorder,instart,inend,map);
        // return root;
    }
    public TreeNode buildtreenow(int[] preorder, int prestart, int preend,int[] inorder, int instart, int inend, Map<Integer,Integer> map){
        if(instart > inend || prestart > preend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int inroot = map.get(root.val);
        int numsleft = inroot - instart;
        System.out.println("prestart"+prestart);
        System.out.println("preend"+preend);
        root.left = buildtreenow(preorder,prestart+1,prestart+numsleft,inorder,instart,inroot-1,map);
        root.right = buildtreenow(preorder,prestart+numsleft+1,preend,inorder,inroot+1,inend,map);
        return root;
    }
}