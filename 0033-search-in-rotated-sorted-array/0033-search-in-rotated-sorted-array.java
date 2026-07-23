class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Agar target mil gaya
            if (nums[mid] == target) {
                return mid;
            }

            // Check karo ki left half sorted hai ya nahi
            if (nums[left] <= nums[mid]) {
                // Target agar left sorted range ke andar hai
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Left me jao
                } else {
                    left = mid + 1;  // Right me jao
                }
            } 
            // Warna right half sorted hoga
            else {
                // Target agar right sorted range ke andar hai
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Right me jao
                } else {
                    right = mid - 1; // Left me jao
                }
            }
        }

        // Agar target nahi mila
        return -1;
    }
}