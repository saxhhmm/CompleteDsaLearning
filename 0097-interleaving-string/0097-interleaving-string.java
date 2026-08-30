class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        // Immediate rejection if lengths don't add up
        if (m + n != s3.length()) {
            return false;
        }
        
        // Use a 1D array sized to match the second string
        boolean[] dp = new boolean[n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Base Case: Both strings are empty
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } 
                // First Row: We only use characters from s2
                else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } 
                // First Column: We only use characters from s1
                else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } 
                // General Case: Check both top (s1) and left (s2) possibilities
                else {
                    boolean matchS1 = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    boolean matchS2 = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    dp[j] = matchS1 || matchS2;
                }
            }
        }
        
        return dp[n];
    }
}