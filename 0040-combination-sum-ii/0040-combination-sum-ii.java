import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // Sort the array to easily skip duplicates and prune early
        Arrays.sort(candidates);
        backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> currentComb, int[] candidates, int remain, int start) {
        if (remain == 0) {
            // We found a valid combination
            results.add(new ArrayList<>(currentComb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same level of the recursion tree
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // Prune the tree: if the current number is too big, the rest are as well
            if (candidates[i] > remain) {
                break;
            }

            // Choose the candidate
            currentComb.add(candidates[i]);
            
            // Explore further (i + 1 ensures we don't reuse the same element)
            backtrack(results, currentComb, candidates, remain - candidates[i], i + 1);
            
            // Backtrack: remove the last added element to try the next one
            currentComb.remove(currentComb.size() - 1);
        }
    }
}