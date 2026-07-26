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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base Case 1: Agar tree khali hai
        if (root == null) {
            return false;
        }
        
        // Check karo ki kya hum leaf node par hain
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        // Recursive step: Baaki bacha hua sum left ya right child me dhundo
        int remainingSum = targetSum - root.val;
        
        boolean leftResult = hasPathSum(root.left, remainingSum);
        boolean rightResult = hasPathSum(root.right, remainingSum);
        
        // Agar kisi bhi taraf se true mil jaye, toh return true
        return leftResult || rightResult;
    }
}