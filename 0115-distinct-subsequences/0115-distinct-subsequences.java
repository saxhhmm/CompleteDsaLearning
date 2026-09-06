class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // Edge case: if t is longer than s, it's impossible
        if (n > m) return 0;
        
        // dp[j] stores the number of distinct subsequences of s matching t up to length j
        int[] dp = new int[n + 1];
        
        // An empty string t is a subsequence of any string s exactly 1 way (by choosing nothing)
        dp[0] = 1;
        
        for (int i = 1; i <= m; i++) {
            // Traverse backwards so we use the old values of dp (representing the previous row)
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // dp[j-1] is using the character, dp[j] is not using it
                    dp[j] = dp[j] + dp[j - 1]; 
                }
            }
        }
        
        return dp[n];
    }
}