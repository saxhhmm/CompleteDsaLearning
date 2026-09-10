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
    // Global variable to keep track of the number of valid nodes
    private int matchingNodesCount = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return matchingNodesCount;
    }

    // Helper method that returns an array: [sum_of_subtree, count_of_nodes]
    private int[] dfs(TreeNode node) {
        // Base case: if the node is null, sum is 0 and count is 0
        if (node == null) {
            return new int[]{0, 0};
        }

        // Recursively fetch the sum and count from left and right children
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // Calculate the total sum and total count for the current subtree
        int currentSum = node.val + left[0] + right[0];
        int currentCount = 1 + left[1] + right[1];

        // Check if the current node's value equals the integer average of its subtree
        if (node.val == currentSum / currentCount) {
            matchingNodesCount++;
        }

        // Pass the sum and count up to the parent node
        return new int[]{currentSum, currentCount};
    }
}