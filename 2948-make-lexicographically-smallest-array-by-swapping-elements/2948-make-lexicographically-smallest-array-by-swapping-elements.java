import java.util.Arrays;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Step 1: Store elements with their original indices
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i]; // Value
            pairs[i][1] = i;       // Original Index
        }
        
        // Sort the array by values
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int i = 0;
        
        // Step 2: Process each connected component (group)
        while (i < n) {
            int j = i + 1;
            
            // Expand the group as long as the difference is within the limit
            while (j < n && pairs[j][0] - pairs[j - 1][0] <= limit) {
                j++;
            }
            
            // Step 3: Extract and sort the original indices for this group
            int groupSize = j - i;
            int[] indices = new int[groupSize];
            for (int k = i; k < j; k++) {
                indices[k - i] = pairs[k][1];
            }
            
            Arrays.sort(indices);
            
            // Step 4: Place the sorted values into the sorted indices
            for (int k = 0; k < groupSize; k++) {
                result[indices[k]] = pairs[i + k][0];
            }
            
            // Move on to the next group
            i = j;
        }
        
        return result;
    }
}