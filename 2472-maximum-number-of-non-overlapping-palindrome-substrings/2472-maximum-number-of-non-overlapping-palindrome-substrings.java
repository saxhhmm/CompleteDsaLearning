class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        
        // Step 1: Precompute palindromes using DP
        boolean[][] isPal = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // A substring is a palindrome if the outer characters match
                // and the inner substring is also a palindrome
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2) {
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i + 1][j - 1];
                    }
                }
            }
        }
        
        // Step 2: 1D DP to find the max non-overlapping palindromes
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // Option 1: Skip the current character
            dp[i] = dp[i - 1];
            
            // Option 2: Find a valid palindrome ending at i - 1
            // We only need to check lengths >= k
            for (int j = i - k; j >= 0; j--) {
                if (isPal[j][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[n];
    }
}