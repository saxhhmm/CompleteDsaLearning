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
    public TreeNode invertTree(TreeNode root) {
        // Base case: agar tree khali hai toh null return karo
        if (root == null) {
            return null;
        }
        
        // Recursively left aur right subtree ko invert karo
        TreeNode leftSubtree = invertTree(root.left);
        TreeNode rightSubtree = invertTree(root.right);
        
        // Current node ke left aur right baccho ko aapas me swap kar do
        root.left = rightSubtree;
        root.right = leftSubtree;
        
        // Invert hone ke baad root return kar do
        return root;
    }
}