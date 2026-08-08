import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // Map to store words from list1 and their indices
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        
        // Loop through list2 to find common words
        for (int j = 0; j < list2.length && j <= minSum; j++) {
            if (map.containsKey(list2[j])) {
                int sum = j + map.get(list2[j]); // Calculate index sum
                
                if (sum < minSum) {
                    // Found a new smaller sum, clear previous results
                    result.clear();
                    result.add(list2[j]);
                    minSum = sum; // Update the minimum sum
                } else if (sum == minSum) {
                    // Found a tie, add to the current results
                    result.add(list2[j]);
                }
            }
        }
        
        // Convert the ArrayList back to a standard String array
        return result.toArray(new String[0]);
    }
}