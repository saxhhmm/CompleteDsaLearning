class Solution {
    public int numDecodings(String s) {
        // If the string is empty or starts with a '0', it cannot be decoded.
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            char current = s.charAt(i - 1);
            char previous = s.charAt(i - 2);
            
            // Check if the single digit is valid (1-9)
            if (current != '0') {
                dp[i] += dp[i - 1];
            }
            
            // Check if the two digits combined are valid (10-26)
            if (previous == '1' || (previous == '2' && current <= '6')) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}