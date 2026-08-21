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
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        // Step 1: Traverse the tree to find the two misplaced nodes
        inorder(root);
        
        // Step 2: Swap their values to recover the BST
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode current) {
        if (current == null) {
            return;
        }

        // Traverse the left subtree
        inorder(current.left);

        // Check for anomalies where the BST property is violated
        if (first == null && prev.val > current.val) {
            first = prev;
        }
        if (first != null && prev.val > current.val) {
            second = current;
        }
        
        // Update the prev pointer
        prev = current;

        // Traverse the right subtree
        inorder(current.right);
    }
}