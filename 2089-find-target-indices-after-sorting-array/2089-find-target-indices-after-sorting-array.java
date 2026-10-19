import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessCount = 0;
        int targetCount = 0;

        // Count elements strictly smaller than target and elements equal to target
        for (int num : nums) {
            if (num < target) {
                lessCount++;
            } else if (num == target) {
                targetCount++;
            }
        }

        // Build the result list with the correct sorted indices
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < targetCount; i++) {
            result.add(lessCount + i);
        }

        return result;
    }
}