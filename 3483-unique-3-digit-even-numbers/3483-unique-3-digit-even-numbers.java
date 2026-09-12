class Solution {
    public int totalNumbers(int[] digits) {
        // Step 1: Count frequencies of each available digit
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }
        
        int total = 0;
        
        // Step 2: Iterate through all possible 3-digit even numbers
        for (int i = 100; i <= 998; i += 2) {
            // Extract the individual digits
            int d1 = i / 100;
            int d2 = (i / 10) % 10;
            int d3 = i % 10;
            
            // Temporarily use the required digits
            count[d1]--;
            count[d2]--;
            count[d3]--;
            
            // Check if we had enough of each digit to form this number
            if (count[d1] >= 0 && count[d2] >= 0 && count[d3] >= 0) {
                total++;
            }
            
            // Restore the counts back to original for the next iteration
            count[d1]++;
            count[d2]++;
            count[d3]++;
        }
        
        return total;
    }
}