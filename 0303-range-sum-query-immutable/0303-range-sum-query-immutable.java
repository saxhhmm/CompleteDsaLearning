class NumArray {
    // Array to store the cumulative sum of elements
    private int[] prefixSum;

    public NumArray(int[] nums) {
        // We use size + 1 to handle the base case where left = 0 cleanly
        prefixSum = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            // prefixSum[i + 1] contains the sum of nums[0] to nums[i]
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        // Subtract the sum of elements before 'left' from the sum up to 'right'
        return prefixSum[right + 1] - prefixSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */