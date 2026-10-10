import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalBudget = (long) k1 + k2;
        
        long sumDiff = 0;
        int maxDiff = 0;
        int[] diff = new int[n];
        
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sumDiff += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }
        
        // If total budget can reduce all differences to 0
        if (sumDiff <= totalBudget) {
            return 0;
        }
        
        // Count frequencies of each difference
        int[] count = new int[maxDiff + 1];
        for (int d : diff) {
            count[d]++;
        }
        
        // Greedily reduce from the largest differences downwards
        for (int i = maxDiff; i > 0 && totalBudget > 0; i--) {
            if (count[i] == 0) continue;
            
            // Number of elements we can reduce from height i to i - 1
            long reduceCount = Math.min(totalBudget, count[i]);
            
            count[i] -= reduceCount;
            count[i - 1] += reduceCount;
            totalBudget -= reduceCount;
        }
        
        // Calculate the final sum of squared differences
        long minSumSquares = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (count[i] > 0) {
                minSumSquares += (long) count[i] * i * i;
            }
        }
        
        return minSumSquares;
    }
}