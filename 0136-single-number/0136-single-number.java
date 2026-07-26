class Solution {
    public int singleNumber(int[] nums) {
        // Shuruat me result 0 rakhte hain
        int result = 0;
        
        // Array ke har element par loop chalayenge
        for (int i = 0; i < nums.length; i++) {
            // Har number ko result ke sath XOR karte jao
            result = result ^ nums[i];
        }
        
        // Jo akela number bachega wahi return kar do
        return result;
    }
}