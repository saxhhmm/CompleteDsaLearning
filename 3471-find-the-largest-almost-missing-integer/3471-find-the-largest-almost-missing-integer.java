class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        // Case 1: k equals the length of the array
        if (k == n) {
            int max = -1;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
        
        // Count frequencies of all elements (since constraints say 0 <= nums[i] <= 50)
        int[] count = new int[51];
        for (int num : nums) {
            count[num]++;
        }
        
        // Case 2: k is 1
        if (k == 1) {
            int max = -1;
            for (int i = 0; i <= 50; i++) {
                if (count[i] == 1) {
                    max = Math.max(max, i);
                }
            }
            return max;
        }
        
        // Case 3: 1 < k < n
        int max = -1;
        // Check if the first element is completely unique
        if (count[nums[0]] == 1) {
            max = Math.max(max, nums[0]);
        }
        // Check if the last element is completely unique
        if (count[nums[n - 1]] == 1) {
            max = Math.max(max, nums[n - 1]);
        }
        
        return max;
    }
}