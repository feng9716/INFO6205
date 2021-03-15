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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(isSame(s,t)){
            return true;
        }
        //If root of s is not same, we will check left and right branches iteratively
        else{
            if(s.left != null && isSubtree(s.left,t)){
                return true;
            }
            if(s.right!= null && isSubtree(s.right,t)){
                return true;
            }
        }
        return false;
        
    }
    
    public boolean isSame(TreeNode s, TreeNode t){
        // Check if both s and t are null --> true;
        // Only one of them is null --> false;
        if(s == null && t == null) return true;
        else if(s==null || t==null) return false;

        //Test if two trees are exactly same
        if(s.val == t.val && isSame(s.left,t.left) && isSame(s.right,t.right)){
            return true;
        }
        return false;

        
    }
}