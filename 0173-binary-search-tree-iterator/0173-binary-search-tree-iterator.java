import java.util.Stack;

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
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        // Initialize the stack with all the left children starting from the root
        pushAllLeft(root);
    }
    
    public int next() {
        // The top of the stack is always the next smallest element
        TreeNode currentNode = stack.pop();
        
        // If there is a right subtree, we need to process its left-most path
        if (currentNode.right != null) {
            pushAllLeft(currentNode.right);
        }
        
        return currentNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    // Helper method to push all left children of a given node onto the stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */