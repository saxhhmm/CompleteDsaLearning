class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        // Root
        result.add(node.val);
        // Left
        traverse(node.left, result);
        // Right
        traverse(node.right, result);
    }
}