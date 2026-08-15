class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        int nonZeroCount = 0;
        
        for (int num : nums) {
            totalXor ^= num;
            if (num != 0) {
                nonZeroCount++;
            }
        }
        
        // Case 1: The whole array already has a non-zero XOR sum
        if (totalXor != 0) {
            return nums.length;
        }
        
        // Case 3: The array consists entirely of zeros
        if (nonZeroCount == 0) {
            return 0;
        }
        
        // Case 2: Total XOR is 0, but we can drop exactly one non-zero element
        return nums.length - 1;
    }
}