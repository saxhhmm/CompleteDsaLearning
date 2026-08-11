import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingInteger(int[] nums) {
        // Step 1: Find the sum of the longest sequential prefix starting from index 0
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Step 2: Store all elements in a HashSet for quick lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // Step 3: Find the smallest integer >= sum that is not in the set
        while (numSet.contains(sum)) {
            sum++;
        }

        return sum;
    }
}