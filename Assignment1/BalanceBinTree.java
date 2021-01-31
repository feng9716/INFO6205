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
    
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    //This will count how many nodes are under root
    public int helper(TreeNode root){
        // if a node is null
        // return 0 for its parent node
        if(root == null) return 0;
        
        // recursive to find nodes on left side and right side
        int left = helper(root.left);
        int right = helper(root.right);
        
        //use -1 to represent that Tree is not balanced

        // if left subtree or right tree is not balance,
        // or if tree's height difference is greater than 1
        // return -1;
        if(Math.abs(left-right) > 1 || left == -1 || right == -1){
            return -1;
        }
        // Find the max of left and right side node number
        // +1 for the count of root
        return Math.max(left,right) + 1;
    }
    
    
    
}