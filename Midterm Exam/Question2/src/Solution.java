import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public static void main(String[] args) {
        // write your code here

        // Create the tree given in the example
        TreeNode four = new TreeNode(4, new TreeNode(8), new TreeNode(9));
        TreeNode five = new TreeNode(5, new TreeNode(10), new TreeNode(11));
        TreeNode six = new TreeNode(6, null, new TreeNode(13));
        TreeNode seven = new TreeNode(7, new TreeNode(14), null);

        TreeNode two = new TreeNode(2, four, five);
        TreeNode three = new TreeNode(3, six, seven);
        TreeNode root = new TreeNode(1, two, three);

        printPerimeter(root);
    }

    public static void printPerimeter(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        printPerimeter(root, 0, 0, stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + "->");
        }
        System.out.println();
    }

    // Time Complexity O(n), we need to traverse all the node in the tree
    // Space Complexity O(n), we used a stack which has the same size of tree;
    public static void printPerimeter(TreeNode root, int left, int right, Stack<Integer> stack) {
        if (root == null) return;
        // Print rightmost Nodes and leaves directly
        if (root.left == null && root.right == null) {
            System.out.print(root.val + "->");
        }
        else if(left == 0){
            System.out.print(root.val + "->");
        }

        // Print leftmost Nodes later, save them in stack for bottom-up order
        else if (right == 0) {
            stack.push(root.val);
        }

        printPerimeter(root.right, left, right+1, stack);
        printPerimeter(root.left, left+1, right, stack);
    }
}
