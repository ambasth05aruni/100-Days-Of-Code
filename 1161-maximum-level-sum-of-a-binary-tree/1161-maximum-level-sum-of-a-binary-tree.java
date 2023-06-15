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
    public int maxLevelSum(TreeNode root) {
          int sum = 0;
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        int maxSum=Integer.MIN_VALUE;
        int ansLevel=0;
        int level=1;
        while(!q.isEmpty()){
            int size = q.size();
            sum=0;
            while(size>0){
                TreeNode node = q.remove();
                sum+=node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                size--;
            }
            if(sum>maxSum){
                maxSum=sum;
                ansLevel = level;
            }
            level++;
        }
        return ansLevel;
    }
}