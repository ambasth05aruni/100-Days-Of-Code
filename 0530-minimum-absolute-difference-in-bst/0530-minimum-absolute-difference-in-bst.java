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
    public int getMinimumDifference(TreeNode root) {
         int mindif= min(root,Integer.MAX_VALUE);
        
         return mindif;
    }
    public TreeNode left(TreeNode root){
        if(root==null)return root;
        if(root.right==null)
            return root;
        return left(root.right);
    }
     public TreeNode right(TreeNode root){
        if(root==null)return root;
        if(root.left==null)
            return root;
        return right(root.left);
    }
    public int min(TreeNode root,int minDif){
        if(root==null)return minDif;
        if(root.left!=null){
            minDif=Math.min(root.val-root.left.val,minDif);
            minDif=min(root.left,minDif);
        }
         if(root.right!=null){
            minDif=Math.min(root.right.val-root.val,minDif);
            minDif=min(root.right,minDif);
        }
        TreeNode left=left(root.left);
        TreeNode right=right(root.right);
        if(left!=null)minDif=Math.min(root.val-left.val,minDif);
         if(right!=null)minDif=Math.min(right.val-root.val,minDif);
        return minDif;
    }
}