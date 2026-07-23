import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Array ko sort karo
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Step 2: Duplicate elements ko skip karo pehle number ke liye
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Agar pehla number hi positive ho gaya, toh sum zero nahi ho sakta
            if (nums[i] > 0) {
                break;
            }

            // Step 3: Two pointers set karo
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Duplicate values ko skip karo left aur right ke liye
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Sum badhane ke liye left pointer aage badhao
                } else {
                    right--; // Sum kam karne ke liye right pointer peeche laao
                }
            }
        }

        return result;
    }
}