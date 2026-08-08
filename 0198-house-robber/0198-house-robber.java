/*class Solution {

    static int solve(int[] nums, int index){
        //base case
        if(index >= nums.length){
            return 0;
        }

        /* 1 case hum solve krenge baki recursion dekh lega
        mai index waale pr hu mere pass 2 choices he include or exclude */

        /*

        int includeAns= nums[index] + solve(nums,index+2);
        int excludeAns= 0 + solve(nums,index+1);
        int finalAns= Math.max(includeAns,excludeAns);
        return finalAns;

    }
    public int rob(int[] nums) {
        int index=0;
        int ans= solve(nums,index);
        return ans;

        
    }
}*/


    class Solution {
    public int rob(int[] nums) {
        // Edge cases
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        // Track the maximum money for the previous two houses
        int prev2 = 0; // Represents max money up to house i-2
        int prev1 = 0; // Represents max money up to house i-1
        
        for (int num : nums) {
            // Calculate the max if we rob the current house OR skip it
            int current = Math.max(prev1, prev2 + num);
            
            // Shift our variables forward for the next iteration
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1; // prev1 holds the maximum total loot by the end
    }
}