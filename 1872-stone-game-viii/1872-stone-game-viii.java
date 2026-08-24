class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        // Step 1: Compute prefix sums
        int[] prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }
        
        // Step 2: Initialize DP with the base case (picking the last possible index)
        int dp = prefix[n - 1];
        
        // Step 3: Work backwards from the second-to-last valid choice down to index 1
        // (Index 0 is not allowed because a player must take x > 1 stones)
        for (int i = n - 2; i >= 1; i--) {
            // Choice 1: Skip this index and take the optimal difference of the next state.
            // Choice 2: Take this index, get prefix[i], and subtract the opponent's optimal future score.
            dp = Math.max(dp, prefix[i] - dp);
        }
        
        return dp;
    }
}