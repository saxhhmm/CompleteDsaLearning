import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            squares[i] = val * val;
        }
        
        // Sort squares in ascending order
        Arrays.sort(squares);
        
        long score = 0;
        int mid = (n + 1) / 2;
        
        for (int i = 0; i < n; i++) {
            if (i < n - mid) {
                score -= squares[i];
            } else {
                score += squares[i];
            }
        }
        
        return score;
    }
}