class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // The "Writer" pointer
        
        // The "Reader" pointer (i) goes through the whole array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is NOT the value we want to remove
            if (nums[i] != val) {
                // Write it to the 'k' position and move 'k' forward
                nums[k] = nums[i];
                k++;
            }
        }
        
        // k will naturally be the count of elements that are not 'val'
        return k;
    }
}