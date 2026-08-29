import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        // Start the backtracking process
        backtrack(result, new ArrayList<>(), nums, used);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        // Base case: we have formed a complete permutation
        if (current.size() == nums.length) {
            // Important: We must add a new ArrayList containing the current elements, 
            // otherwise we'd just be adding references to the same modifying list.
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Iterate through the available choices
        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already in the current permutation
            if (used[i]) {
                continue;
            }
            
            // 1. Choose the element
            used[i] = true;
            current.add(nums[i]);
            
            // 2. Explore further down this path
            backtrack(result, current, nums, used);
            
            // 3. Backtrack: un-choose the element to explore other paths
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}