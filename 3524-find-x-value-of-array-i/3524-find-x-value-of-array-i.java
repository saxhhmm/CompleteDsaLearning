class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        
        // dp[rem] stores the number of valid subarrays ending at the current element
        // that have product modulo k equal to rem
        long[] dp = new long[k];
        
        for (int num : nums) {
            long[] newDp = new long[k];
            int numMod = num % k;
            
            // 1. Option to start a new single-element subarray
            newDp[numMod] = 1;
            
            // 2. Option to extend previous subarrays
            for (int rem = 0; rem < k; rem++) {
                if (dp[rem] > 0) {
                    int nextRem = (int) ((1L * rem * numMod) % k);
                    newDp[nextRem] += dp[rem];
                }
            }
            
            // 3. Accumulate subarray counts into the final answer
            for (int rem = 0; rem < k; rem++) {
                ans[rem] += newDp[rem];
            }
            
            dp = newDp;
        }
        
        return ans;
    }
}