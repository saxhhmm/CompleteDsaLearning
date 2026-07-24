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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Agar dono nodes null hain, toh structure aur value same hain
        if (p == null && q == null) {
            return true;
        }
        
        // Agar dono mein se ek null hai, ya values alag hain, toh false
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Dono ke left branches check karo, AUR right branches check karo
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}