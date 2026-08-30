class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        
        // If the array has 1 or 2 elements, we must remove all of them.
        if (n <= 2) {
            return n;
        }
        
        int minIndex = 0;
        int maxIndex = 0;
        
        // Step 1: Find the indices of the minimum and maximum elements
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // Ensure 'i' is the smaller index and 'j' is the larger index
        int i = Math.min(minIndex, maxIndex);
        int j = Math.max(minIndex, maxIndex);
        
        // Step 2: Calculate the cost of the 3 strategies
        int costFront = j + 1;
        int costBack = n - i;
        int costBothSides = (i + 1) + (n - j);
        
        // Step 3: Return the minimum of the three strategies
        return Math.min(costFront, Math.min(costBack, costBothSides));
    }
}