class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // Array ka pehla element initialize kar lo
        int currSum = 0;

        for (int num : nums) {
            // Current number ko sum me add karo
            currSum += num;

            // Maximum sum ko update karo
            maxSum = Math.max(maxSum, currSum);

            // Agar sum negative ho gaya, toh ise reset kar do (fayda nahi hai ise aage le jaane ka)
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}