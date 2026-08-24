import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> present = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // Step 1: Find min, max, and store elements for O(1) lookups
        for (int num : nums) {
            present.add(num);
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        List<Integer> missing = new ArrayList<>();
        
        // Step 2 & 3: Iterate through the theoretical range and find missing pieces
        for (int i = min; i <= max; i++) {
            if (!present.contains(i)) {
                missing.add(i);
            }
        }
        
        return missing;
    }
}