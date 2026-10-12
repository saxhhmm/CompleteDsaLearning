import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCounts = new int[32];
        
        // Step 1: Count set bits for each position
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCounts[i]++;
                }
            }
        }
        
        long MOD = 1_000_000_007;
        long totalSum = 0;
        
        // Step 2: Greedily build k elements to maximize their values
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit < 32; bit++) {
                if (bitCounts[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCounts[bit]--;
                }
            }
            totalSum = (totalSum + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) totalSum;
    }
}