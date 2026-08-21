class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        
        // Find the minimum coin to set our upper bound
        long minCoin = coins[0];
        for (int c : coins) {
            minCoin = Math.min(minCoin, c);
        }
        
        int totalSubsets = 1 << n; // 2^n
        long[] lcm = new long[totalSubsets];
        int[] setSize = new int[totalSubsets];
        
        // Step 1: Precompute LCM and subset sizes for all 2^N - 1 combinations
        for (int i = 1; i < totalSubsets; i++) {
            long currentLcm = 1;
            int bits = 0;
            for (int j = 0; j < n; j++) {
                // If the j-th bit is set, include coins[j] in the subset
                if ((i & (1 << j)) != 0) {
                    bits++;
                    currentLcm = getLcm(currentLcm, coins[j]);
                }
            }
            lcm[i] = currentLcm;
            setSize[i] = bits;
        }
        
        // Step 2: Binary Search the Answer
        long left = 1;
        long right = (long) k * minCoin;
        long result = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = 0;
            
            // Step 3: Apply Inclusion-Exclusion Principle
            for (int i = 1; i < totalSubsets; i++) {
                if (setSize[i] % 2 == 1) {
                    count += mid / lcm[i]; // Add odd-sized sets
                } else {
                    count -= mid / lcm[i]; // Subtract even-sized sets
                }
            }
            
            // If the count is sufficient, this could be the answer, but try for a smaller one
            if (count >= k) {
                result = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; // We need a larger amount to reach k combinations
            }
        }
        
        return result;
    }
    
    // Helper to calculate Greatest Common Divisor
    private long getGcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Helper to calculate Least Common Multiple
    private long getLcm(long a, long b) {
        return (a / getGcd(a, b)) * b;
    }
}