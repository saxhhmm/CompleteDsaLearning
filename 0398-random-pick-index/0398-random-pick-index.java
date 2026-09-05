import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> indexMap;
    private Random random;

    public Solution(int[] nums) {
        indexMap = new HashMap<>();
        random = new Random();
        
        // Store all indices for each number
        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indices = indexMap.get(target);
        // Pick a random index from the list of valid indices
        return indices.get(random.nextInt(indices.size()));
    }
}