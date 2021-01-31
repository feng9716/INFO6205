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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        // if root is null, return a null List
        if(root == null) return res;
        findMaximumHeight(root,0);
        
        return res;
    }
    
    public int findMaximumHeight(TreeNode root,int height){
        int height_l = 0, height_r = 0;
        if(root == null) return 0;
        if(root.left != null || root.right != null){
            if(root.left != null) {
                height_l = findMaximumHeight(root.left,height) ;
            }
            if(root.right != null) {
                height_r = findMaximumHeight(root.right,height) ;
            }
        }
        
        int height_t = Math.max(height_l,height_r)+1;
        if(res.size() < height_t){
            res.add(height_t-1,new ArrayList<>());
        }
        res.get(height_t-1).add(root.val);
        
        
        return height_t;
    }

}