class Solution {
    public int[] runningSum(int[] nums) {
        // Start from index 1 and add the previous running sum to the current element
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        
        return nums;
    }
}