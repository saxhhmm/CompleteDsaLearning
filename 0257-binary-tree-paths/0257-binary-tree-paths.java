import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        // If the tree is empty, return the empty list
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }
    
    private void dfs(TreeNode node, String path, List<String> result) {
        // Add the current node's value to the path
        path += node.val;
        
        // If it is a leaf node, the path is complete
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            // If it is not a leaf, add the arrow and keep exploring
            path += "->";
            if (node.left != null) {
                dfs(node.left, path, result);
            }
            if (node.right != null) {
                dfs(node.right, path, result);
            }
        }
    }
}