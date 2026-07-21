class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: Left prefix products store karo
        res[0] = 1; // Pehle element ke left me kuch nahi hota
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: Right suffix products se multiply karo
        int right = 1; // Rightmost element ke right me kuch nahi hota
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right *= nums[i]; // Next element ke liye right product update kar do
        }

        return res;
    }
}