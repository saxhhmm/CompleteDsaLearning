import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        // 1. Go Left
        traverse(node.left, result);
        // 2. Visit Node (Root)
        result.add(node.val);
        // 3. Go Right
        traverse(node.right, result);
    }
}