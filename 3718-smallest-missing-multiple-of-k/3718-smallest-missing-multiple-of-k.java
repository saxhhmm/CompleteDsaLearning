class Solution {
    public int missingMultiple(int[] nums, int k) {
        // Since 1 <= nums[i] <= 100, we only need an array of size 101
        boolean[] present = new boolean[101];
        
        // Mark all numbers in the array as present
        for (int num : nums) {
            present[num] = true;
        }
        
        int multiple = k;
        
        // Check consecutive multiples of k
        while (true) {
            // If the multiple is not in the array, or it exceeds 100 (meaning it can't possibly be in the array), return it
            if (multiple > 100 || !present[multiple]) {
                return multiple;
            }
            multiple += k;
        }
    }
}