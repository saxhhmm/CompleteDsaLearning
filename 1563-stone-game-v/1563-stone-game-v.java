class Solution {
    private int[] prefix;
    private int[][] memo;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        
        // Precompute prefix sums for O(1) subarray sum queries
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        
        // Initialize memoization table
        memo = new int[n][n];
        
        return dfs(0, n - 1);
    }

    private int dfs(int left, int right) {
        // Base case: only 1 stone left, game ends, score is 0
        if (left == right) {
            return 0;
        }
        
        // Return precomputed result if available
        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        int maxScore = 0;
        
        // Try every possible split point i
        for (int i = left; i < right; i++) {
            int leftSum = prefix[i + 1] - prefix[left];
            int rightSum = prefix[right + 1] - prefix[i + 1];

            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + dfs(left, i));
            } else if (leftSum > rightSum) {
                maxScore = Math.max(maxScore, rightSum + dfs(i + 1, right));
            } else { // leftSum == rightSum
                maxScore = Math.max(maxScore, leftSum + Math.max(dfs(left, i), dfs(i + 1, right)));
            }
        }

        return memo[left][right] = maxScore;
    }
}