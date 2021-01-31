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
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        res = sumOfLeftLeaves(root,res);
        
        return res;
    }
    
    public int sumOfLeftLeaves(TreeNode root, int sum){
        if(root == null) return sum;
        
        //For left child nodes, we will examine if it is leaf nodes
        if(root.left != null){
            // if it is leaf nodes, we add its value to sum
            if(root.left.left==null && root.left.right==null){
                sum += root.left.val;
            }
            // if it is not, we process recursive method to this left child nodes
            else{
                sum = sumOfLeftLeaves(root.left,sum);
            }
            
        }
        
        // For right nodes, we always process recursive method on it.
        if(root.right != null){
            sum = sumOfLeftLeaves(root.right,sum);
        }
        // return the sum;
        return sum;
    }
}