import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        
        // best[i] stores the minimum length of a valid subarray in arr[0...i]
        int[] best = new int[n];
        int INF = Integer.MAX_VALUE / 2; // Prevent overflow on addition
        Arrays.fill(best, INF);
        
        int ans = INF;
        int sum = 0;
        int l = 0;
        
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            
            // Shrink window if sum exceeds target
            while (sum > target) {
                sum -= arr[l++];
            }
            
            // Found a valid subarray matching target
            if (sum == target) {
                int currentLen = r - l + 1;
                
                // If a valid non-overlapping subarray exists to the left, update answer
                if (l > 0 && best[l - 1] != INF) {
                    ans = Math.min(ans, best[l - 1] + currentLen);
                }
                
                best[r] = currentLen;
            }
            
            // Carry over the minimum subarray length found so far
            if (r > 0) {
                best[r] = Math.min(best[r], best[r - 1]);
            }
        }
        
        return ans >= INF ? -1 : ans;
    }
}