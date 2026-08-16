class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        
        // Count frequencies of each remainder when divided by 3
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        // If the number of type-0 stones is even
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        } 
        // If the number of type-0 stones is odd
        else {
            return Math.abs(count[1] - count[2]) > 2;
        }
    }
}