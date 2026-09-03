class Solution {
    public boolean uniformArray(int[] nums1) {
        int minVal = Integer.MAX_VALUE;
        boolean hasOdd = false;
        
        // Find the minimum value and check for the presence of any odd numbers
        for (int num : nums1) {
            if (num < minVal) {
                minVal = num;
            }
            if (num % 2 != 0) {
                hasOdd = true;
            }
        }
        
        // If the smallest number is odd, we can always make everything odd.
        if (minVal % 2 != 0) {
            return true;
        }
        
        // If the smallest number is even, we can only succeed if there are NO odd numbers.
        return !hasOdd;
    }
}